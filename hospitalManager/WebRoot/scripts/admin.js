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
					var password=doctors[i].password;
					var level=doctors[i].level;
					var dept=doctors[i].dept;
					var specialty=doctors[i].specialty;
					var phone=doctors[i].phone;
					//拼一个li元素
					createDoctorTb(did,name,age,sex,password,level,dept,specialty,phone);
				}
			}
		},
		error:function(){
			alert("查询失败");
		}	
		});	
};

//创建查询医生表头
function createDoctorTh(){
	var th='<tr>';
		th+=' <td>编号</td>';
		th+=' <td>姓名</td>';
		th+=' <td>年龄</td>';
		th+=' <td>性别</td>';
		th+=' <td>密码</td>';		
		th+=' <td>职称等级</td>';
		th+=' <td>所属部门</td>';
		th+=' <td>专业精通</td>';	
		th+=' <td>联系方式</td>';		
		th+=' <td>操作选择</td>';
		th+='</tr>';
		var $th=$(th);
		$("#th").append($th);					
};

//追加一个医生tr
function createDoctorTb(did,name,age,sex,password,level,dept,specialty,phone){
	var s_li ='<tr>';
		s_li+='	<td>'+did+'</td>';
		s_li+='	<td>'+name+'</td>';
		s_li+='	<td>'+age+'</td>';
		s_li+='	<td>'+sex+'</td>';
		s_li+='	<td>'+password+'</td>';
		s_li+='	<td>'+level+'</td>';
		s_li+='	<td>'+dept+'</td>';
		s_li+='	<td>'+specialty+'</td>';
		s_li+='	<td>'+phone+'</td>';
		s_li+='  <td><input  type="button" value="修改" onclick="upd(this)"/>&nbsp&nbsp<input  type="button" value="删除" onclick="del(this)"></td>';
		s_li+='</tr>';
		var $tr=$(s_li);
		$("#tb").append($tr);
};

//创建添加医生表格
function createAddDoctorTable(){
	$("#th").empty();
	$("#tb").empty();
	$("#new").empty();
	var tr='<tr class="t1"><td class="d1">编号：</td><td colspan="2"><input id="did" type="text" class="width150" /></td><td><span id="num_span" class="required"></span></td></tr>';
	tr+='<tr class="t1"><td class="d1">姓名：</td><td colspan="2"><input id="name" type="text" class="width150" /></td><td><span id="name_span" class="required"></span></td></tr>';
	tr+='<tr class="t1"><td class="d1">年龄：</td><td colspan="2"><input id="age" type="text" class="width150" /></td><td><span id="age_span" class="required"></span></td></tr>';
	tr+='<tr class="t1"><td class="d1">性别：</td><td colspan="2"><input name="sex" type="radio" value="男"/>男&nbsp<input name="sex" type="radio" value="女"/>女</td><td><span id="sex_span" class="required"></span></td></tr>';
	tr+='<tr class="t1"><td class="d1">密码：</td><td colspan="2"><input id="password" type="password" class="width150" /></td><td><span id="pwd_span" class="required"></span></td></tr>';
	tr+='<tr class="t1"><td class="d1">职称等级：</td><td colspan="2"><input id="level" type="text" class="width150" /></td><td><span id="level_span" class="required"></span></td></tr>';
	tr+='<tr class="t1"><td class="d1">所属部门：</td><td colspan="2"><input id="dept" type="text" class="width150" /></td><td><span id="dept_span" class="required"></span></td></tr>';
	tr+='<tr class="t1"><td class="d1">专业精通：</td><td colspan="2"><input id="specialty" type="text" class="width150" /></td><td><span id="specialty_span" class="required"></span></td></tr>';
	tr+='<tr class="t1"><td class="d1">联系方式：</td><td colspan="2"><input id="phone" type="text" class="width150" /></td><td><span id="phone_span" class="required"></span></td></tr>';
	tr+='<tr><td></td><td><input id="save" type="button" value="&nbsp保&nbsp存&nbsp"/></td><td><input type="reset" value="&nbsp重&nbsp置&nbsp"/></td></tr> ';
	var $tr=$(tr);
	$("#new").append($tr);
 };
 
//创建修改医生表格
 function createUpdateTable(did,name,password,level,dept,specialty,phone){
 	$("#th").empty();
 	$("#tb").empty();
 	$("#new").empty();
 	var tr='<tr class="t1"><td class="d1">编号：</td><td colspan="2"><input id="did" type="text" value="'+did+'" readonly class="width150" /></td><td><span id="num_span" class="required"></span></td></tr>';
 	tr+='<tr class="t1"><td class="d1">姓名：</td><td colspan="2"><input id="name" type="text" value="'+name+'" readonly class="width150" /></td><td><span id="name_span" class="required"></span></td></tr>'; 	
 	tr+='<tr class="t1"><td class="d1">密码：</td><td colspan="2"><input id="password" type="password" value="'+password+'" class="width150" /></td><td><span id="pwd_span" class="required"></span></td></tr>';
 	tr+='<tr class="t1"><td class="d1">职称等级：</td><td colspan="2"><input id="level" type="text" value="'+level+'" class="width150" /></td><td><span id="level_span" class="required"></span></td></tr>';
 	tr+='<tr class="t1"><td class="d1">所属部门：</td><td colspan="2"><input id="dept" type="text" value="'+dept+'" class="width150" /></td><td><span id="dept_span" class="required"></span></td></tr>';
 	tr+='<tr class="t1"><td class="d1">专业精通：</td><td colspan="2"><input id="specialty" type="text" value="'+specialty+'" class="width150" /></td><td><span id="specialty_span" class="required"></span></td></tr>';
 	tr+='<tr class="t1"><td class="d1">联系方式：</td><td colspan="2"><input id="phone" type="text" value="'+phone+'" class="width150" /></td><td><span id="phone_span" class="required"></span></td></tr>';
 	tr+='<tr><td></td><td><input id="updsave" type="button" value="&nbsp保&nbsp存&nbsp"/></td><td><input type="reset" value="&nbsp重&nbsp置&nbsp"/></td></tr> ';
 	var $tr=$(tr);
 	$("#new").append($tr);

  };
 
//删除医生
 function del(btn){
	 var did=$(btn).parent().siblings().eq(0).html().trim();
	 $.ajax({
			url:base_url+"/admin/deleteDoctor.do",
			type:"post",
			data:{"did":did},
			dataType:"json",
			success:function(result){
			if(result.status==0){//正确		
				findAllDoctor();
			}
			},
			error:function(){
				alert("删除异常，稍后重试");
			}
		}); 
 }
 
//修改医生
 function upd(btn){
	 var did=$(btn).parent().siblings().eq(0).html().trim();
	 $.ajax({
			url:base_url+"/admin/upd.do",
			type:"post",
			data:{"did":did},
			dataType:"json",
			success:function(result){
			if(result.status==0){//正确		
				var doctor = result.data;//医生数组
				   var did=doctor.did;
				   var name=doctor.name;
				   var password=doctor.password;
				   var level=doctor.level;
				   var dept=doctor.dept;
				   var specialty=doctor.specialty;
				   var phone=doctor.phone;
				   createUpdateTable(did,name,password,level,dept,specialty,phone);							
			}
			},
			error:function(){
				alert("修改异常，稍后重试");
			}
		}); 

 }
 
//保存修改的医生
 function saveUpdateDoctor(){
	//清空之前的提示信息
		$("#num_span").html("");
		$("#pwd_span").html("");
		$("#name_span").html("");
		$("#phone_span").html("");
		$("#level_span").html("");
		$("#dept_span").html("");
		$("#specialty_span").html("");
		//获取请求参数
		var num=$("#did").val().trim();
		var pwd=$("#password").val().trim();
		var name=$("#name").val().trim();
		var level=$("#level").val().trim();
		var phone=$("#phone").val().trim();
		var dept=$("#dept").val().trim();
		var specialty=$("#specialty").val().trim();
		//检查参数格式
		var ok=true;
		if(pwd==""){
			ok=false;
			$("#pwd_span").html("密码不能为空");
		}
		if(phone==""){
			ok=false;
			$("#phone_span").html("必须填入联系方式");
		}
		if(level==""){
			ok=false;
			$("#level_span").html("必须填入级别");
		}
		if(dept==""){
			ok=false;
			$("#dept_span").html("必须填入部门");
		}
		if(specialty==""){
			ok=false;
			$("#specialty_span").html("必须填入专业");
		}
		if(ok){
			$.ajax({
				url:base_url+"/admin/updateDoctor.do",
				type:"post",
				data:{"did":num,"password":pwd,"name":name,"phone":phone,"level":level,
					"specialty":specialty,"dept":dept},
				dataType:"json",
				success:function(result){
				if(result.status==0){//正确
					alert(result.msg);							
					window.location.href="adminOperation.html";
				}
				},
				error:function(){
					alert("添加异常，稍后重试");
				}
			});
		}
	};
 
 //保存添加的医生
 function saveAddDoctor(){
	//清空之前的提示信息
		$("#num_span").html("");
		$("#pwd_span").html("");
		$("#name_span").html("");
		$("#sex_span").html("");
		$("#age_span").html("");
		$("#phone_span").html("");
		$("#level_span").html("");
		$("#dept_span").html("");
		$("#specialty_span").html("");
		//获取请求参数
		var num=$("#did").val().trim();
		var pwd=$("#password").val().trim();
		var name=$("#name").val().trim();
		var sex=$("input:radio:checked").val();
		var age=$("#age").val().trim();
		var level=$("#level").val().trim();
		var phone=$("#phone").val().trim();
		var dept=$("#dept").val().trim();
		var specialty=$("#specialty").val().trim();
		//检查参数格式
		var ok=true;
		if(num==""){
			ok=false;
			$("#num_span").html("编号不能为空");
		}
		if(pwd==""){
			ok=false;
			$("#pwd_span").html("密码不能为空");
		}
		if(name==""){
			ok=false;
			$("#name_span").html("请输入姓名");
		}
		if(sex==null){
			ok=false;
			$("#sex_span").html("请选择性别");
		}
		if(age==""){
			ok=false;
			$("#age_span").html("请填入年龄");
		}
		if(phone==""){
			ok=false;
			$("#phone_span").html("必须填入联系方式");
		}
		if(level==""){
			ok=false;
			$("#level_span").html("必须填入级别");
		}
		if(dept==""){
			ok=false;
			$("#dept_span").html("必须填入部门");
		}
		if(specialty==""){
			ok=false;
			$("#specialty_span").html("必须填入专业");
		}
		if(ok){
			$.ajax({
				url:base_url+"/admin/addDoctor.do",
				type:"post",
				data:{"did":num,"password":pwd,"name":name,"sex":sex,"age":age,"phone":phone,"level":level,
					"specialty":specialty,"dept":dept},
				dataType:"json",
				success:function(result){
				if(result.status==0){//正确
					alert(result.msg);							
					window.location.href="adminOperation.html";
				}else if(result.status==1){//编号重复
					$("#num_span").html(result.msg);
				}
				},
				error:function(){
					alert("添加异常，稍后重试");
				}
			});
		}
	};