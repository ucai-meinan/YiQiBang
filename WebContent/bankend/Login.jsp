<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录账户</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="jquery/jquery-1.11.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<style>
.second {
	margin-left: 30px;
}

.my_panel {
	margin-top: 180px;
}

.first {
	margin-left: 60px;
}

.mybody {
	margin-top: 30px;
}
</style>
</head>
<body>
	<div id="page">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="panel panel-primary my_panel">
						<div class="panel-heading">
							<h3 class="panel-title">登录帐号</h3>
						</div>
						<form>
							<div class="col-md-8 col-md-offset-2">
								<div class-body class="mybody">
									<div>
										<ul class="nav nav-tabs" role="tablist">

											<li role="presentation" class="active first"><a
												href="#account" aria-controls="account" role="tab"
												data-toggle="tab">帐号登录</a></li>
											<li role="presentation" class="second"><a href="#note"
												aria-controls="note" role="tab" data-toggle="tab">短信登录</a></li>
										</ul>
										<div class="tab-content">

											<div role="tabpanel" class="tab-pane active" id="account">
												<div class="row">
													<!--行-->
													<div class="col-md-12 account_box">
														<input type="text" class="form-control"
															 placeholder="用户名/手机/邮箱">
													</div>
												</div>
												<div class="row">
													<!--行-->
													<div class="col-md-12 pwd_box">
														<input type="password" class="form-control"
															  placeholder="请输入密码">
													</div>
												</div>
											</div>
											<div role="tabpanel" class="tab-pane" id="note">2...</div>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>