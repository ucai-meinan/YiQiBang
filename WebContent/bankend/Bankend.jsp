<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻管理后台页面</title>
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<script src="../jquery/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="../bankendCss/NewsManager.css">
<script src="../js/date_util.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>

<!-- eEditor -->
<!-- 配置文件 -->
<script type="text/javascript" src="uEditer/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="uEditer/ueditor.all.js"></script>


<script>
	$(function() {
		getAllNews();
		getAllTypes();
	});
	function getAllNews() {
		$('#myModal').modal('show');
		$.getJSON("/YiQiBang/NewsServlet", {
			action : "adminSelectAllNews"
		}, function(data) {
			showNewsData(data);
		});
	}

	function showNewsData(data) {
		if (data.retMsg) {
			$("#newsList_body").html("");
			var newslist = data.retData;
			for (var i = 0; i < newslist.length; i++) {
				var news = newslist[i];
				$("#newsList_body")
						.append(
								'<tr align="center" class="news_tr">' + '<td>'
										+ (i + 1)
										+ '</td>'
										+ '<td id="type'+i+'"></td>'
										+ '<td>'
										+ news.title
										+ '</td>'
										+ '<td>'
										+ news.source
										+ '</td>'
										+ '<td>'
										+ news.author
										+ '</td>'
										+ '<td>'
										+ news.content
										+ '</td>'
										+ '<td>'
										+ getStrDate(news.createtime.time)
										+ '</td>'
										+ '<td>'
										+ news.commCount
										+ '</td>'
										+ '<td>'
										+ news.readCount
										+ '</td>'
										+ '<td>'
										+ (news.ifHot ? "是" : "否")
										+ '</td>'
										+ '<td>'
										+ (news.ifReport ? "是" : "否")
										+ '</td>'
										+ '<td class="icon_row">'
										+ '<div class="row">'
										+ '<div class="col-md-6 text-center">'
										+ '<span class="glyphicon glyphicon-cog cofigBtn" id="configBtn'+i+'" ></span>'
										+ '</div>'
										+ '<div class="col-md-6 text-center">'
										+ '<span class="glyphicon glyphicon-trash" id="deleteBtn'
										+ i + '" onclick="deleteNew(' + news.id
										+ ')"></span>' + '</div>' + '</div>'
										+ '</td>' + '</tr>');

				getTypeById(news.typeId, i);
			}
			$(".cofigBtn").each(function(index) {
				$("#configBtn" + index).click(function() {
					var news = newslist[index];
					//1.把模态框放出来
					$("#addNewsModal").modal('show');
					//2.将模态框里面显示的数据变成news对象里面的数据
					$("#myModalLabel").text("修改新闻");//修改模态框标题
					$("#addNewsModal #typeid").val(news.typeId);
					$("#addNewsModal #title").val(news.title);
					$("#addNewsModal #source").val(news.source);
					$("#addNewsModal #author").val(news.author);
					$("#newsid").val(news.id);
					//3.修改确定按钮 事件
					var ue = UE.getEditor('editor',{ 
						initialFrameWidth : 700,
                		initialFrameHeight : 300
					});
					ue.setContent(news.content);
					console.log(news);
					if (news.ifHot) {
						$("#yes").attr("checked", true);
						$("#no").removeAttr("checked");
					} else {
						$("#yes").removeAttr("checked");
						$("#no").attr("checked", true);
					}
				});
			});
			$('#myModal').modal('hide');
		}
	}
	/*根据id删除新闻*/
	function deleteNew(newsId) {
		$.ajax({
			url : "/YiQiBang/NewsServlet",//请求url地址
			data : { //请求参数对象
				action : "adminDeleteNewsById",
				id : newsId
			},
			timeout : 5000,//请求超时时间，以ms为单位
			type : "post",//请求方式
			beforesend : function() { //请求开始发送之前的回掉方法
				$('#myModal').modal('show');
			},
			success : function(data) {//请求成功回掉函数
				var objData = JSON.parse(data);
				if (objData.retCode == 0) {
					location.reload();
				}

			},
			error : function(e) {//请求失败回掉函数
				alert("类型获取异常" + e);
			},
			complete : function() {//请求完成时候的回调函数
				$('#myModal').modal('hide');
			}
		});
	}

	/*根据id删除新闻*/
	function deleteNew(newsId) {
		$.ajax({
			url : "/YiQiBang/NewsServlet",//请求url地址
			data : { //请求参数对象
				action : "adminDeleteNewsById",
				id : newsId
			},
			timeout : 5000,//请求超时时间，以ms为单位
			type : "post",//请求方式
			beforesend : function() { //请求开始发送之前的回掉方法
				$('#myModal').modal('show');
			},
			success : function(data) {//请求成功回掉函数
				var objData = JSON.parse(data);
				if (objData.retCode == 0) {
					location.reload();
				}
			},
			error : function(e) {//请求失败回掉函数
				alert("类型获取异常" + e);
			},
			complete : function() {//请求完成时候的回调函数
				$('#myModal').modal('hide');
			}
		});
	}

	/*根据类型id获取类型*/
	function getTypeById(typeId, index) {
		$.ajax({
			url : "/YiQiBang/TypeServlet",//请求url地址
			data : {
				action : "adminGetTypeById",
				id : typeId
			},
			timeout : 5000,//请求超时时间，以ms为单位
			type : "get",
			beforesend : function() {
				$('#myModal').modal('show');
			},
			success : function(data) {
				var objData = JSON.parse(data);//将字符串对象转化为js的Object对象
				if (objData.retCode == 0) {
					$("#type" + index).text(objData.retData.name);
				}
			},
			error : function(e) {
				alert("类型获取异常" + e);
			},
			complete : function() {
				$('#myModal').modal('hide');
			}
		});
	}

	/**
	 * 获取所有类型
	 */
	function getAllTypes() {
		$.ajax({
			url : "/YiQiBang/TypeServlet",
			data : {
				action : "adminGetAllTypes"
			},
			type : "get",
			timeout : 5000,
			beforesend : function() {
				$('#myModal').modal('show');
				
			},
			success : function(data) {				
				var jsData = JSON.parse(data);
				$("#typeid").html("");
				for (var i = 0; i < jsData.retData.length; i++) {
					var type = jsData.retData[i];
					$("#typeid").append(
							'<option value="'+type.id+'">' + type.name
							+ '</option>');
				}
			},
			error : function(e) {
				alert("上传失败");
			},
			complete : function() {
				$('#myModal').modal('hide');
			}
		});
		
	}
	
	function addNewsBtn() {
		$("#addNewsModal").modal('show');
	}

	function searchNewsByLike() {
		var searchTv = $("#searchTv").val();
		if (searchTv == "") {
			getAllNews();
		} else {
			$.ajax({
				url : "/YiQiBang/NewsServlet",
				data : {
					action : "adminGetNewsByLike",
					likeStr : searchTv
				},
				type : "get",
				timeout : 5000,
				beforesend : function() {
					$('#myModal').modal('show');
				},
				success : function(data) {
					var datas=JSON.parse(data);
					showNewsData(datas);
				},
				error : function(e) {
					alert("上传失败");
				},
				complete : function() {
					$('#myModal').modal('hide');
				}
			});
		}


	}
</script>
<body>
	<div>
		<div id="head">
			<nav class="navbar navbar-default clear" id="color">
				<div class="container-fluid">
					<div class="navbar-header left">
						<img src="" alt="请选择头像图片"> <a class="navbar-brand" href="#">石老师</a>
					</div>
					<div class="collapse navbar-collapse middle"
						id="bs-example-navbar-collapse-1">
						<form class="navbar-form navbar-left">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="请输入关键词">
							</div>
							<button type="submit" class="btn btn-default">
								<img src="" alt="">
							</button>
						</form>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="#"><img src="" alt=""></a></li>
							<li><a href="#"><img src="" alt=""></a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		<div id="content">
			<div class="left col-md-2">
				<ul class="nav nav-tabs" role="tablist" id="myTabs">
					<li role="presentation" class="active"><a href="#home"
						aria-controls="home" role="tab" data-toggle="tab">用户管理</a></li>
					<li role="presentation"><a href="#profile"
						aria-controls="profile" role="tab" data-toggle="tab">新闻管理</a></li>
					<li role="presentation"><a href="#messages"
						aria-controls="messages" role="tab" data-toggle="tab">评论管理</a></li>
					<li role="presentation"><a href="#settings"
						aria-controls="settings" role="tab" data-toggle="tab">新闻爬虫</a></li>
					<li role="presentation"><a href="#news" aria-controls="news"
						role="tab" data-toggle="tab">新闻分类管理</a></li>
				</ul>
			</div>

			<div class="tab-content right col-md-10">
				<div role="tabpanel" class="tab-pane active mytable" id="home">
					111111</div>
				<div role="tabpanel" class="tab-pane mytable" id="profile">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div class="row cop_row">
								<div class="col-md-2">
									<h4>新闻列表</h4>
								</div>
								<div class="col-md-offset-2 col-md-3">
									<div class="input-group">
										<input type="text" class="form-control"
											placeholder="标题/内容/时间/来源" id="searchTv"> <span
											class="input-group-btn">
											<button class="btn btn-default" type="button"
											onclick="searchNewsByLike()">
											<span class="glyphicon glyphicon-search"></span>
										</button>
										</span>
									</div>
								</div>
								<div class="col-md-offset-3 col-md-2">
									<button type="button" class="btn btn-default btn-sm"
										onclick="addNewsBtn()">
										<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
										添加
									</button>
								</div>
							</div>

						</div>

						<div class="panel-body">
							<table class="table table-bordered table-stripted">
								<thead>
									<tr>
										<th>序号</th>
										<th>类型</th>
										<th>标题</th>
										<th>来源</th>
										<th>作者</th>
										<th>内容</th>
										<th>时间</th>
										<th>评论</th>
										<th>浏览</th>
										<th>是否热点</th>
										<th>是否被举报</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody id="newsList_body">

								</tbody>
							</table>
						</div>
						<div class="panel-footer text-center">
							<nav aria-label="Page navigation">
								<ul class="pagination">
									<li><a href="#" aria-label="Previous"> <span
											aria-hidden="true">&laquo;</span>
									</a></li>
									<li class="active"><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
									<li><a href="#" aria-label="Next"> <span
											aria-hidden="true">&raquo;</span>
									</a></li>
								</ul>
							</nav>
						</div>
					</div>
				</div>
				<div role="tabpanel" class="tab-pane mytable" id="messages">
					22222222222</div>
				<div role="tabpanel" class="tab-pane mytable" id="settings">
					33333333333</div>
				<div role="tabpanel" class="tab-pane mytable" id="news">
					44444444444444</div>
			</div>
		</div>

	</div>

	<!-- Modal -->
	<div class="modal fade" id="addNewsModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">

					<h4 class="modal-title" id="myModalLabel">添加新闻</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="addNewsForm"
						action="/java_web_pro/NewsServlet?action=adminInsertNews"
						method="post">
						<div class="form-group">
							<label class="col-sm-2 control-label">类型</label>
							<div class="col-sm-8">
								<select id="typeid" name="typeid" class="form-control"></select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">标题</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="title" name="title"
									placeholder="sdf a" value="daf ">
									<input type="hidden" id="newsid" value="0">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">来源</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="source"
									name="source" placeholder="dasf " value="dsf">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">作者</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="author"
									name="author" placeholder="sdf " value="restg ">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">内容</label>
							<div class="col-sm-9">
								<div>
									<script id="editor" type="text/plain"></script>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">是否为热点</label>
							<div class="col-sm-8">
								<label class="radio-inline"> <input type="radio"
									name="ifHot" id="yes" value="true" checked>是
								</label> <label class="radio-inline"> <input type="radio"
									name="ifHot" id="no" value="false"> 否
								</label>

							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary"
						onclick="addNewsSure()">确定</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="progress.jsp"></jsp:include>


</body>
<script type="text/javascript">
	$("#myModal").modal('show');

	//实例化编辑器
	var ue = UE.getEditor('editor', {
		//focus时自动清空初始化时的内容
		autoClearinitialContent : true,
		//关闭字数统计
		wordCount : false,
		//关闭elementPath
		elementPathEnabled : false,
		//默认的编辑区域高度
		initialFrameWidth : 700,
		initialFrameHeight : 300
	//更多其他参数，请参考ueditor.config.js中的配置项
	});
	//添加新闻按钮点击事件
	function addNewsSure() {
		var title = $("#title").val();
		var source = $('#source').val();
		var author = $("#author").val();
		var content = ue.getContent();
		var type = $("#typeid").val();
		var modal_title = $("#myModalLabel").text();
		var ifHot = $("#yes").prop("checked") ? true : false;
		if (title == "" || source == "" || author == "" || content == "") {
			alert("请输入内容");
			return;
		}
		var data = {
				title : title,
				typeId : type,
				content : content,
				source : source,
				author : author,
				ifHot : ifHot
			}
		if (modal_title == "修改新闻") {
			data.newsid=$("#newsid").val();
			data.action="adminUpdateNews";
		} else {
			data.action ="adminInsertNews";
		}
		$.ajax({
			url : "/YiQiBang/NewsServlet",
			data : data,
			type : "post",
			timeout : 5000,
			beforesend : function() {
				$('#myModal').modal('show');
			},
			success : function(data) {
				console.log(data);
				var jsData = JSON.parse(data);
				if (jsData.retCode == 0) {
					location.reload();
				}
			},
			error : function(e) {
				alert("caozuo失败");
			},
			complete : function() {
				$('#myModal').modal('hide');
				$("#addNewsModal").modal('hide');
			}
		});
	}
</script>

</html>