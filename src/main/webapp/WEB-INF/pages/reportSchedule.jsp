<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>SIAcademics | Student With most Subject Reports</title>

<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="${pageContext.request.contextPath}/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link
	href="${pageContext.request.contextPath}/vendors/nprogress/nprogress.css"
	rel="stylesheet">
<!-- iCheck -->
<link
	href="${pageContext.request.contextPath}/vendors/iCheck/skins/flat/green.css"
	rel="stylesheet">
<!-- bootstrap-wysiwyg -->
<link
	href="${pageContext.request.contextPath}/vendors/google-code-prettify/bin/prettify.min.css"
	rel="stylesheet">
<!-- Select2 -->
<link
	href="${pageContext.request.contextPath}/vendors/select2/dist/css/select2.min.css"
	rel="stylesheet">
<!-- Switchery -->
<link
	href="${pageContext.request.contextPath}/vendors/switchery/dist/switchery.min.css"
	rel="stylesheet">
<!-- starrr -->
<link
	href="${pageContext.request.contextPath}/vendors/starrr/dist/starrr.css"
	rel="stylesheet">
<!-- bootstrap-daterangepicker -->
<link
	href="${pageContext.request.contextPath}/vendors/bootstrap-daterangepicker/daterangepicker.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="${pageContext.request.contextPath}/build/css/custom.min.css"
	rel="stylesheet">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/build/js/jquery-1.4.2.min.js"></script>

</head>

<body class="nav-md">

	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="index.html" class="site_title"><i
							class="fa fa-institution"></i> <span>SI<b>Academics</b></span></a>
					</div>

					<div class="clearfix"></div>

					<!-- menu profile quick info -->
					<div class="profile clearfix">
						<div class="profile_pic">
							<img
								src="${pageContext.request.contextPath}/build/images/img.jpg"
								alt="..." class="img-circle profile_img">
						</div>
						<div class="profile_info">
							<span>Welcome,</span>
							<h2>John Doe</h2>
						</div>
					</div>
					<!-- /menu profile quick info -->

					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<h3>Main Navigation</h3>
							<ul class="nav side-menu">
								<li><a><i class="fa fa-home"></i> Home <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="index.html">Dashboard</a></li>
									</ul></li>
								<li><a><i class="fa fa-edit"></i> Form Creates <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="${pageContext.request.contextPath}/major">Major</a>
										</li>
										<li><a href="${pageContext.request.contextPath}/subject">Subject</a>
										</li>
										<li><a href="${pageContext.request.contextPath}/student">Student</a>
										</li>
										<li><a href="${pageContext.request.contextPath}/subMajor">Sub-Major</a>
										</li>
										<li><a href="${pageContext.request.contextPath}/room">Room</a></li>
										<li><a href="${pageContext.request.contextPath}/schedule">Schedule</a></li>
									</ul></li>

								<li><a><i class="fa fa-table"></i> Table Views <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="${pageContext.request.contextPath}/subjects">Subjects</a></li>
										<li><a href="${pageContext.request.contextPath}/students">Students</a></li>
										<li><a href="${pageContext.request.contextPath}/majors">Majors</a></li>
										<li><a
											href="${pageContext.request.contextPath}/subMajors">Sub-Majors</a></li>
										<li><a
											href="${pageContext.request.contextPath}/frstudies">FRS</a></li>
										<li><a href="${pageContext.request.contextPath}/rooms">Rooms</a></li>
										<li><a
											href="${pageContext.request.contextPath}/schedules">Schedules</a></li>
									</ul></li>
								<li><a><i class="fa fa-bar-chart-o"></i> Reports <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a
											href="${pageContext.request.contextPath}/subjectReports">Favorite
												Subjects</a></li>
										<li><a
											href="${pageContext.request.contextPath}/majorReports">Major
												with the most Subjects</a></li>
										<li><a
											href="${pageContext.request.contextPath}/studentReports">Student
												with most Subjects</a></li>
									</ul></li>
							</ul>
						</div>


					</div>
					<!-- /sidebar menu -->

					<!-- /menu footer buttons -->
					<div class="sidebar-footer hidden-small">
						<a data-toggle="tooltip" data-placement="top" title="Settings">
							<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="FullScreen">
							<span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Lock"> <span
							class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Logout"
							href="login.html"> <span class="glyphicon glyphicon-off"
							aria-hidden="true"></span>
						</a>
					</div>
					<!-- /menu footer buttons -->
				</div>
			</div>

			<!-- top navigation -->
			<div class="top_nav">
				<div class="nav_menu">
					<nav>
						<div class="nav toggle">
							<a id="menu_toggle"><i class="fa fa-bars"></i></a>
						</div>
						<ul class="nav navbar-nav navbar-right">
							<li class=""><a href="javascript:;"
								class="user-profile dropdown-toggle" data-toggle="dropdown"
								aria-expanded="false"> <img
									src="${pageContext.request.contextPath}/build/images/img.jpg"
									alt="">John Doe <span class=" fa fa-angle-down"></span>
							</a>
								<ul class="dropdown-menu dropdown-usermenu pull-right">
									<li><a href="javascript:;"> Profile</a></li>
									<li><a href="javascript:;"> <span
											class="badge bg-red pull-right">50%</span> <span>Settings</span>
									</a></li>
									<li><a href="javascript:;">Help</a></li>
									<li><a href="login.html"><i
											class="fa fa-sign-out pull-right"></i> Log Out</a></li>
								</ul></li>
						</ul>

					</nav>
				</div>
			</div>
			<!-- /top navigation -->

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Student with Most Subject Reports</h3>
						</div>

						<div class="title_right">
							<div
								class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
								<div class="input-group">
									<input type="text" class="form-control"
										placeholder="Search for..."> <span
										class="input-group-btn">
										<button class="btn btn-default" type="button">Go!</button>
									</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>Reports</h2>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<br />
									<form:form
										action="${pageContext.request.contextPath}/reportSchedule"
										method="GET">
										<table>
											<tr>
												<td width="40%"><label class="control-label col-md-3 col-sm-3 col-xs-12">Days</label></td>
												<td>
													<select class="form-control" name="days" style="width: 200%">
														<option value="Monday" label="Monday" />
														<option value="Tuesday" label="Tuesday" />
														<option value="Wednesday" label="Wednesday" />
														<option value="Thursday" label="Thrusday" />
														<option value="Friday" label="Friday" />
														<option value="Saturday" label="Saturday" />
													</select>
												</td>
											<tr>
											<td><br /></td>
											</tr>
											<tr>
												<td><label class="control-label col-md-3 col-sm-3 col-xs-12">Jam Masuk</label></td>
												<td><input name="in1" class="form-control" placeholder="Enter Jam Masuk" required="required" style="width: 200%"></input>

												</td>
											</tr>
											<tr>
											<td><br /></td>
											</tr>
											<tr>
												<td><label class="control-label col-md-3 col-sm-3 col-xs-12">Jam Keluar</label></td>
												<td><input name="in2" class="form-control" placeholder="Enter Jam Keluar" required="required" style="width: 200%"></input>

												</td>
											</tr>
										</table>
										<br/><br/>

										<div class="form-group">
											<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">

												<button id=hide type="submit" class="btn btn-success">Submit</button>
												<button class="btn btn-primary" type="reset" id=reset>Reset</button>
												<a href="${pageContext.request.contextPath}/schedules"
													class="btn btn-warning">Cancel</a>
											</div>
										</div>

										<br />
										<br />
										<div class="ln_solid"></div>
										<div class="x_content">
											<div class="table-responsive">
												<table class="table table-striped jambo_table bulk_action">
													<thead>
														<tr class="headings">

															<th class="column-title">No</th>
															<th class="column-title">Code</th>
															<th class="column-title">Name</th>
															<th class="column-title">Room</th>
															<th class="column-title">Start</th>
															<th class="column-title">End</th>
															<th class="bulk-actions" colspan="7"><a
																class="antoo" style="color: #fff; font-weight: 500;">Bulk
																	Actions ( <span class="action-cnt"> </span> ) <i
																	class="fa fa-chevron-down"></i>
															</a></th>
														</tr>
													</thead>

													<tbody>
														<tr class="even pointer">
															<c:forEach items="${reportSchedule}" var="info"
																varStatus="status">
																<tr>
																	<td>${status.index + 1}</td>
																	<td>${info[0]}</td>
																	<td>${info[1]}</td>
																	<td>${info[2]}</td>
																	<td>${info[3]}</td>
																	<td>${info[4]}</td>
																</tr>
															</c:forEach>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
									</form:form>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
			<!-- /page content -->

			<!-- footer content -->
			<footer>
				<div class="pull-right">
					Gentelella - Bootstrap Admin Template by <a
						href="https://colorlib.com">Colorlib</a>
				</div>
				<div class="clearfix"></div>
			</footer>
			<!-- /footer content -->
		</div>
	</div>

	<script type="text/javascript">

		$("#show").click(function () {
   			$("table").show(1000);
			});

		$("#hide").click(function () {
   			$("table").hide(1000);
			});

		$("#reset").click(function(){
			location.reload();
			});
	</script>

	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath}/vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script
		src="${pageContext.request.contextPath}/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script
		src="${pageContext.request.contextPath}/vendors/fastclick/lib/fastclick.js"></script>
	<!-- NProgress -->
	<script
		src="${pageContext.request.contextPath}/vendors/nprogress/nprogress.js"></script>
	<!-- bootstrap-progressbar -->
	<script
		src="${pageContext.request.contextPath}/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
	<!-- iCheck -->
	<script
		src="${pageContext.request.contextPath}/vendors/iCheck/icheck.min.js"></script>
	<!-- bootstrap-daterangepicker -->
	<script
		src="${pageContext.request.contextPath}/vendors/moment/min/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
	<!-- bootstrap-wysiwyg -->
	<script
		src="${pageContext.request.contextPath}/vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendors/google-code-prettify/src/prettify.js"></script>
	<!-- jQuery Tags Input -->
	<script
		src="${pageContext.request.contextPath}/vendors/jquery.tagsinput/src/jquery.tagsinput.js"></script>
	<!-- Switchery -->
	<script
		src="${pageContext.request.contextPath}/vendors/switchery/dist/switchery.min.js"></script>
	<!-- Select2 -->
	<script
		src="${pageContext.request.contextPath}/vendors/select2/dist/js/select2.full.min.js"></script>
	<!-- Parsley -->
	<script
		src="${pageContext.request.contextPath}/vendors/parsleyjs/dist/parsley.min.js"></script>
	<!-- Autosize -->
	<script
		src="${pageContext.request.contextPath}/vendors/autosize/dist/autosize.min.js"></script>
	<!-- jQuery autocomplete -->
	<script
		src="${pageContext.request.contextPath}/vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"></script>
	<!-- starrr -->
	<script
		src="${pageContext.request.contextPath}/vendors/starrr/dist/starrr.js"></script>
	<!-- Custom Theme Scripts -->
	<script src="${pageContext.request.contextPath}/build/js/custom.min.js"></script>

	<script
		src="${pageContext.request.contextPath}/build/js/checking.min.js"></script>

</body>
</html>
