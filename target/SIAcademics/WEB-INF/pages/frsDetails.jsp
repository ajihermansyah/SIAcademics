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
	  
    <title>SIAcademics | FRS Details </title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath}/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${pageContext.request.contextPath}/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="${pageContext.request.contextPath}/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- bootstrap-wysiwyg -->
    <link href="${pageContext.request.contextPath}/vendors/google-code-prettify/bin/prettify.min.css" rel="stylesheet">
    <!-- Select2 -->
    <link href="${pageContext.request.contextPath}/vendors/select2/dist/css/select2.min.css" rel="stylesheet">
    <!-- Switchery -->
    <link href="${pageContext.request.contextPath}/vendors/switchery/dist/switchery.min.css" rel="stylesheet">
    <!-- starrr -->
    <link href="${pageContext.request.contextPath}/vendors/starrr/dist/starrr.css" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="${pageContext.request.contextPath}/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath}/build/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.html" class="site_title"><i class="fa fa-institution"></i> <span>SI<b>Academics</b></span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                <img src="${pageContext.request.contextPath}/build/images/img.jpg" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Welcome,</span>
                <h2>John Doe</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>Main Navigation</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="index.html">Dashboard</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-edit"></i> Form Creates <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                   	    <li><a href="${pageContext.request.contextPath}/major">Major</a> </li>
						<li><a href="${pageContext.request.contextPath}/subject">Subject</a> </li>
						<li><a href="${pageContext.request.contextPath}/student">Student</a> </li>
						<li><a href="${pageContext.request.contextPath}/subMajor">Sub-Major</a> </li>
						<li><a href="${pageContext.request.contextPath}/room">Room</a></li>
						<li><a href="${pageContext.request.contextPath}/schedule">Schedule</a></li>
                    </ul>
                  </li>
              
                  <li><a><i class="fa fa-table"></i> Table Views <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="${pageContext.request.contextPath}/subjects">Subjects</a></li>
					  <li><a href="${pageContext.request.contextPath}/students">Students</a></li>
					  <li><a href="${pageContext.request.contextPath}/majors">Majors</a></li>
		     	 	  <li><a href="${pageContext.request.contextPath}/subMajors">Sub-Majors</a></li>
					  <li><a href="${pageContext.request.contextPath}/frstudies">FRS</a></li>
					  <li><a href="${pageContext.request.contextPath}/rooms">Rooms</a></li>
					  <li><a href="${pageContext.request.contextPath}/schedules">Schedules</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-bar-chart-o"></i> Reports <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                     <li><a href="${pageContext.request.contextPath}/subjectReports">Favorite Subjects</a></li>
					 <li><a href="${pageContext.request.contextPath}/majorReports">Major with the most Subjects</a></li>
					 <li><a href="${pageContext.request.contextPath}/studentReports">Student with most Subjects</a></li>
                    </ul>
                  </li>
                </ul>
              </div>
              

            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
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
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="${pageContext.request.contextPath}/build/images/img.jpg" alt="">John Doe
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="javascript:;"> Profile</a></li>
                    <li>
                      <a href="javascript:;">
                        <span class="badge bg-red pull-right">50%</span>
                        <span>Settings</span>
                      </a>
                    </li>
                    <li><a href="javascript:;">Help</a></li>
                    <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                  </ul>
                </li>
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
                <h3>FRS Details</h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
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
                    <h2>Student Data</h2>
                    <div class="clearfix"></div>
                  </div>
				  <div class="x_content">
                    <br />
                   	<table class="table">
						<tr>
							<td><label>NIM</label></td>
							<td>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" value ="${frsInfos.nim}" class="form-control"/>
								</div>
							</td>
						</tr>
						<tr>
						    <td><label>Name</label></td>
						    <td>
						        <div class="col-md-6 col-sm-6 col-xs-12">
						          <input type="text" value ="${frsInfos.name}" class="form-control"/>
								</div>
							</td>
						</tr>
						<tr>
						    <td><label>Lecture</label></td>
						    <td>
						    	<div class="col-md-6 col-sm-6 col-xs-12">
						    		<input type="text" value ="${frsInfos.dosen_wali}" class="form-control"/>
								</div>
						</tr>
						<tr>
						    <td><label>FRS Date</label></td>
						    <td>
						    	<div class="col-md-6 col-sm-6 col-xs-12">
						    		<input type="text" value ="${frsInfos.tgl_frs}" class="form-control"/>
						    	</div>	
						    </td>
						</tr>
						<tr>
						    <td><label>Semester</label></td>
						    <td>
						    	<div class="col-md-6 col-sm-6 col-xs-12">
						    		<input type="text" value ="${frsInfos.semester}" class="form-control"/>
						    	</div>
						    </td>
						</tr>
					</table>
                  </div>
                </div>
			 </div>
           </div>
            
            <div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Subject List</h2>
                    <div class="clearfix"></div>
                  </div>
				  <div class="x_content">
                    <br />
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Data</h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <table id="datatable" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>No</th>
                          <th>Subject Code</th>
                          <th>Subject Name</th>
                          <th>SKS</th>
                          <th>Semester</th>
                        </tr>
                      </thead>

                      <tbody>
                       <c:forEach items="${frsDetailInfos}" var="info" varStatus="status">
							<tr>
					    		<td>${status.index + 1}</td>
								<td>${info.sbjId.subjectCode}</td>
								<td>${info.sbjId.subjectName}</td>
								<td>${info.sbjId.sks}</td>
								<td>${info.sbjId.semester}</td>
							</tr>
						</c:forEach>
                        
                      </tbody>
                    </table>
                  </div>
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
            Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="${pageContext.request.contextPath}/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="${pageContext.request.contextPath}/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="${pageContext.request.contextPath}/vendors/nprogress/nprogress.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="${pageContext.request.contextPath}/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="${pageContext.request.contextPath}/vendors/iCheck/icheck.min.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="${pageContext.request.contextPath}/vendors/moment/min/moment.min.js"></script>
    <script src="${pageContext.request.contextPath}/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
    <!-- bootstrap-wysiwyg -->
    <script src="${pageContext.request.contextPath}/vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
    <script src="${pageContext.request.contextPath}/vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
    <script src="${pageContext.request.contextPath}/vendors/google-code-prettify/src/prettify.js"></script>
    <!-- jQuery Tags Input -->
    <script src="${pageContext.request.contextPath}/vendors/jquery.tagsinput/src/jquery.tagsinput.js"></script>
    <!-- Switchery -->
    <script src="${pageContext.request.contextPath}/vendors/switchery/dist/switchery.min.js"></script>
    <!-- Select2 -->
    <script src="${pageContext.request.contextPath}/vendors/select2/dist/js/select2.full.min.js"></script>
    <!-- Parsley -->
    <script src="${pageContext.request.contextPath}/vendors/parsleyjs/dist/parsley.min.js"></script>
    <!-- Autosize -->
    <script src="${pageContext.request.contextPath}/vendors/autosize/dist/autosize.min.js"></script>
    <!-- jQuery autocomplete -->
    <script src="${pageContext.request.contextPath}/vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"></script>
    <!-- starrr -->
    <script src="${pageContext.request.contextPath}/vendors/starrr/dist/starrr.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="${pageContext.request.contextPath}/build/js/custom.min.js"></script>
    <script src="${pageContext.request.contextPath}/build/js/checking.min.js"></script>
	
  </body>
</html>
