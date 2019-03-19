//创建搜索表头
function createFindNameTable(){
	$("#query").empty();
	$("#th").empty();
	$("#tb").empty();
	$("#new").empty();
	var tr='<tr><td>请输入查询医生的名字：</td>';
	tr+='<td><input id="name" type="text"/></td>';
	tr+='<td><input id="findName" type="button" value="搜索"/></td></tr>';
	var $tr=$(tr);
	$("#query").append($tr);
};

//创建搜索表头
function createFindSpecialtyTable(){
	$("#query").empty();
	$("#th").empty();
	$("#tb").empty();
	$("#new").empty();
	var tr='<tr><td>请输入查询的相关专业：</td>';
	tr+='<td><input id="specialty" type="text"/></td>';
	tr+='<td><input id="findSpecialty" type="button" value="搜索"/></td></tr>';
	var $tr=$(tr);
	$("#query").append($tr);
};

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

//创建查询医生表头
function createDoctorTh(){
	var th='<tr>';
		th+=' <td>编号</td>';
		th+=' <td>姓名</td>';
		th+=' <td>年龄</td>';
		th+=' <td>性别</td>';	
		th+=' <td>职称等级</td>';
		th+=' <td>所属部门</td>';
		th+=' <td>专业精通</td>';	
		th+=' <td>联系方式</td>';		
		th+=' <td>预约时间（如2016-05-01  09:30:00）</td>';
		th+='</tr>';
		var $th=$(th);
		$("#th").append($th);					
};

//查询所有医生
function findAllDoctor(){
	$("#th").empty();
	$("#tb").empty();
	$("#new").empty();
	$("#query").empty();
	$.ajax({
		url:base_url+"/admin/findAllDoctor.do",
		type:"post",
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var doctors = result.data;//医生数组
				createDoctorTh();
				for(var i=0;i<doctors.length;i++){
					var did = doctors[i].did;
					var name=doctors[i].name;
					var age=doctors[i].age;
					var sex=doctors[i].sex;
					var level=doctors[i].level;
					var dept=doctors[i].dept;
					var specialty=doctors[i].specialty;
					var phone=doctors[i].phone;
					//拼一个li元素
					createDoctorTb(did,name,age,sex,level,dept,specialty,phone);
				}
			}
		},
		error:function(){
			alert("查询失败");
		}	
		});	
};

//取消预约
function cancel(btn){
	 var cid=$(btn).parent().siblings().eq(0).html().trim();
	 $.ajax({
			url:base_url+"/patient/cancelReserve.do",
			type:"post",
			data:{"cid":cid},
			dataType:"json",
			success:function(result){
			if(result.status==0){//正确		
				findReserve();
			}
			},
			error:function(){
				alert("删除异常，稍后重试");
			}
		}); 
}

//添加预约信息
function add(btn){
	 var dname=$(btn).parent().siblings().eq(1).html().trim();
	 var did=$(btn).parent().siblings().eq(0).html().trim();
	 var time=$(btn).next().val().trim();
	 $.ajax({
			url:base_url+"/patient/reservation.do",
			type:"post",
			data:{"did":did,"pid":user,"dname":dname,"rDay":time},
			dataType:"json",
			success:function(result){
			if(result.status==0){//正确		
				alert(result.msg);
				findAllDoctor();
			}
			if(result.status==1){//时间小于当前系统时间
				alert(result.msg);
			}
			},
			error:function(){
				alert("添加异常，稍后重试");
			}
		}); 
}

//追加一个预约tr
function createReserveTb(cid,dname,pid,rDate,rDay){
	var s_li ='<tr>';
		s_li+='	<td>'+cid+'</td>';
		s_li+='	<td>'+dname+'</td>';
		s_li+='	<td>'+pid+'</td>';
		s_li+='	<td>'+rDate+'</td>';
		s_li+='	<td>'+rDay+'</td>';
		s_li+='  <td><input  type="button" value="取消预约" onclick="cancel(this)"/></td>';
		s_li+='</tr>';
		var $tr=$(s_li);
		$("#tb").append($tr);
};

//追加一个医生tr
function createDoctorTb(did,name,age,sex,level,dept,specialty,phone){
	var s_li ='<tr>';
		s_li+='	<td>'+did+'</td>';
		s_li+='	<td>'+name+'</td>';
		s_li+='	<td>'+age+'</td>';
		s_li+='	<td>'+sex+'</td>';
		s_li+='	<td>'+level+'</td>';
		s_li+='	<td>'+dept+'</td>';
		s_li+='	<td>'+specialty+'</td>';
		s_li+='	<td>'+phone+'</td>';
		s_li+='  <td><input type="button" value="预约" onclick="add(this)"/>&nbsp&nbsp<input type="text" class="width150"/></td>';
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
		url:base_url+"/patient/findReserve.do",
		type:"post",
		data:{"pid":user},
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

//根据名字查医生
function findDoctorName(){
	$("#th").empty();
	$("#tb").empty();
	$("#new").empty();
	var name=$("#name").val().trim();
	$.ajax({
		url:base_url+"/patient/findLikeName.do",
		type:"post",
		data:{"name":name},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var doctors = result.data;//医生数组
				createDoctorTh();
				for(var i=0;i<doctors.length;i++){
					var did = doctors[i].did;
					var name=doctors[i].name;
					var age=doctors[i].age;
					var sex=doctors[i].sex;
					var level=doctors[i].level;
					var dept=doctors[i].dept;
					var specialty=doctors[i].specialty;
					var phone=doctors[i].phone;
					//拼一个li元素
					createDoctorTb(did,name,age,sex,level,dept,specialty,phone);
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

//根据专业查医生
function findDoctorSpecialty(){
	$("#th").empty();
	$("#tb").empty();
	$("#new").empty();
	var specialty=$("#specialty").val().trim();
	$.ajax({
		url:base_url+"/patient/findLikeSpecialty.do",
		type:"post",
		data:{"specialty":specialty},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var doctors = result.data;//医生数组
				createDoctorTh();
				for(var i=0;i<doctors.length;i++){
					var did = doctors[i].did;
					var name=doctors[i].name;
					var age=doctors[i].age;
					var sex=doctors[i].sex;
					var level=doctors[i].level;
					var dept=doctors[i].dept;
					var specialty=doctors[i].specialty;
					var phone=doctors[i].phone;
					//拼一个li元素
					createDoctorTb(did,name,age,sex,level,dept,specialty,phone);
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