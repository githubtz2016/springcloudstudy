//创建添加病历表格
function createAddMRTable(pname,user){
	$("#th").empty();
	$("#tb").empty();
	$("#new").empty();
	var	tr='<tr class="t1"><td class="d1">医生编号：</td><td colspan="2"><input id="did" type="text" readonly value="'+user+'" class="width150" /></td></tr>';
	tr+='<tr class="t1"><td class="d1">患者姓名：</td><td colspan="2"><input id="pname" type="text"  readonly  value="'+pname+'" class="width150" /></td></tr>';
	tr+='<tr class="t1"><td class="d1">病情描述：</td><td colspan="2"><textarea  id="description" rows="4" cols="10"></textarea></td></tr>';
	tr+='<tr class="t1"><td class="d1">诊断结果：</td><td colspan="2"><textarea  id="diagnose" rows="4" cols="10"></textarea></td></tr>';
	tr+='<tr class="t1"><td class="d1">处方：</td><td colspan="2"><textarea  id="prescribe" rows="4" cols="10"></textarea></td></tr>';
	tr+='<tr class="t1"><td class="d1">上次更新时间：</td><td colspan="1"><input id="time" readonly type="text" class="width150" /></td></tr>';
	tr+='<tr><td></td><td><input id="saveMR" type="button" value="&nbsp保&nbsp存&nbsp"/></td><td><input type="reset" value="&nbsp重&nbsp置&nbsp"/></td></tr> ';
	var $tr=$(tr);
	$("#new").append($tr);
 };
 
//创建修改病历表格
 function createUpdateMRTable(rid,pname,did,description,diagnose,prescribe,fDate){
 	$("#th").empty();
 	$("#tb").empty();
 	$("#new").empty();
 	var	tr='<tr class="t1"><td class="d1">病历单号：</td><td colspan="2"><input id="rid" type="text"  readonly  value="'+rid+'" class="width150" /></td></tr>';
 	tr+='<tr class="t1"><td class="d1">医生编号：</td><td colspan="2"><input id="did" type="text" readonly value="'+did+'" class="width150" /></td></tr>';
 	tr+='<tr class="t1"><td class="d1">患者姓名：</td><td colspan="2"><input id="pname" type="text"  readonly  value="'+pname+'" class="width150" /></td></tr>';
 	tr+='<tr class="t1"><td class="d1">病情描述：</td><td colspan="2"><textarea  id="description"  rows="4" cols="10">'+description+'</textarea></td></tr>';
 	tr+='<tr class="t1"><td class="d1">诊断结果：</td><td colspan="2"><textarea  id="diagnose"  rows="4" cols="10">'+diagnose+'</textarea></td></tr>';
 	tr+='<tr class="t1"><td class="d1">处方：</td><td colspan="2"><textarea  id="prescribe"  rows="4" cols="10">'+prescribe+'</textarea></td></tr>';
 	tr+='<tr class="t1"><td class="d1">上次更新时间：</td><td colspan="1"><input id="time" readonly type="text" value="'+fDate+'" class="width150" /></td></tr>';
 	tr+='<tr><td></td><td><input id="saveupdMR" type="button" value="&nbsp保&nbsp存&nbsp"/></td><td><input type="reset" value="&nbsp重&nbsp置&nbsp"/></td></tr> ';
 	var $tr=$(tr);
 	$("#new").append($tr);
  };

//保存修改的病历
  function saveUpdateMR(){
 		//获取请求参数
	    var rid=$("#rid").val().trim();
 		var num=$("#did").val().trim();
 		var pname=$("#pname").val().trim();
 		var description=$("#description").val().trim();
 		var diagnose=$("#diagnose").val().trim();
 		var prescribe=$("#prescribe").val().trim();
 			$.ajax({
 				url:base_url+"/doctor/updateMR.do",
 				type:"post",
 				data:{"rid":rid,"did":num,"pname":pname,"description":description,"diagnose":diagnose,"prescribe":prescribe},
 				dataType:"json",
 				success:function(result){
 				if(result.status==0){//正确
 					alert(result.msg);							
 					findReserve();
 				}
 				},
 				error:function(){
 					alert("修改异常，稍后重试");
 				}
 			});
 		
 	};  
  
//保存创建的病历
 function saveAddMR(){
		//获取请求参数
		var num=$("#did").val().trim();
		var pname=$("#pname").val().trim();
		var description=$("#description").val().trim();
		var diagnose=$("#diagnose").val().trim();
		var prescribe=$("#prescribe").val().trim();
			$.ajax({
				url:base_url+"/doctor/creatMR.do",
				type:"post",
				data:{"did":num,"pname":pname,"description":description,"diagnose":diagnose,"prescribe":prescribe},
				dataType:"json",
				success:function(result){
				if(result.status==0){//正确
					alert(result.msg);							
					window.location.href="doctorOperation.html";
				}else if(result.status==1){
					alert(result.msg);
					findReserve();
				}
				},
				error:function(){
					alert("添加异常，稍后重试");
				}
			});
		
	};
 
 //创建病历
 function creatMR(btn){
	 var pid=$(btn).parent().siblings().eq(2).html().trim();
	 $.ajax({
			url:base_url+"/doctor/returnMR.do",
			type:"post",
			data:{"pid":pid,"did":user},
			dataType:"json",
			success:function(result){
			if(result.status==1){//正确		
				var pname=result.data;
				createAddMRTable(pname,user);
			}else if(result.status==0){
				alert(result.msg);
				findReserve();
			}
			},
			error:function(){
				alert("创建异常，稍后重试");
			}
		}); 
 }

 //修改病历
 function updMR(btn){
	 var pid=$(btn).parent().siblings().eq(2).html().trim();
	 $.ajax({
			url:base_url+"/doctor/returnMR.do",
			type:"post",
			data:{"pid":pid,"did":user},
			dataType:"json",
			success:function(result){
			if(result.status==0){//正确	
				var mr=result.data;
				var rid=mr.rid;
				var pname=mr.pname;	
				var description=mr.description;	
				var did=mr.did;	
				var diagnose=mr.diagnose;	
				var prescribe=mr.prescribe;	
				var fDate=mr.fDate;
				createUpdateMRTable(rid,pname,did,description,diagnose,prescribe,fDate);
			}else if(result.status==1){
				alert(result.msg);
			}
			},
			error:function(){
				alert("修改异常，稍后重试");
			}
		}); 
 }
 
//创建查询预约表头
function createReserveTh(){
	var th='<tr>';
		th+=' <td>预约单号</td>';
		th+=' <td>医生姓名</td>';
		th+=' <td>对应患者编号</td>';
		th+=' <td>创建表单时间</td>';	
		th+=' <td>预约就诊时间</td>';	
		th+=' <td>操作选择</td>';
		th+='</tr>';
		var $th=$(th);
		$("#th").append($th);					
};

//追加一个预约tr
function createReserveTb(cid,dname,pid,rDate,rDay){
	var s_li ='<tr>';
		s_li+='	<td>'+cid+'</td>';
		s_li+='	<td>'+dname+'</td>';
		s_li+='	<td>'+pid+'</td>';
		s_li+='	<td>'+rDate+'</td>';
		s_li+='	<td>'+rDay+'</td>';
		s_li+='  <td><input  type="button" value="创建患者病历"  onclick="creatMR(this)"/>&nbsp&nbsp<input  type="button" value="修改患者病历"   onclick="updMR(this)"/></td>';
		s_li+='</tr>';
		var $tr=$(s_li);
		$("#tb").append($tr);
};

//根据编号查预约信息
function findReserve(){
	$("#th").empty();
	$("#tb").empty();
	$("#new").empty();
	$("#query").empty();
	$.ajax({
		url:base_url+"/doctor/findReserve.do",
		type:"post",
		data:{"did":user},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var reserves = result.data;//预约数组
				createReserveTh();
				for(var i=0;i<reserves.length;i++){
					var cid = reserves[i].cid;
					var dname=reserves[i].dname;
					var pid=reserves[i].pid;
					var rDate=reserves[i].datetime;
					var rDay=reserves[i].daytime;
					//拼一个li元素
					createReserveTb(cid,dname,pid,rDate,rDay);
				}
			}
			if(result.status==1){
				alert(result.msg);
			}
		},
		error:function(){
			alert("查询失败");
		}	
		});	
};
