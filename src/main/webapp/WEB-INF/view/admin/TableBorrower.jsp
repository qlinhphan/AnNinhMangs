<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                <!DOCTYPE html>
                <html lang="en">

                <head>

                    <meta charset="utf-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                    <meta name="description" content="">
                    <meta name="author" content="">

                    <title>SB Admin 2 - Dashboard</title>

                    <!-- Custom fonts for this template-->
                    <link href="/css/all.min.css" rel="stylesheet" type="text/css">
                    <link
                        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
                        rel="stylesheet">

                    <!-- Custom styles for this template-->
                    <link href="/css/sb-admin-2.min.css" rel="stylesheet">

                </head>

                <body id="page-top">

                    <!-- Page Wrapper -->
                    <div id="wrapper">

                        <!-- Sidebar -->
                        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                            <!-- Sidebar - Brand -->
                            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/admin">
                                <div class="sidebar-brand-icon rotate-n-15">
                                    <i class="fas fa-laugh-wink"></i>
                                </div>
                                <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
                            </a>

                            <!-- Divider -->
                            <hr class="sidebar-divider my-0">

                            <!-- Nav Item - Dashboard -->
                            <li class="nav-item active">
                                <a class="nav-link" href="/admin">
                                    <i class="fas fa-fw fa-tachometer-alt"></i>
                                    <span>Dashboard</span></a>
                            </li>

                            <!-- Divider -->
                            <hr class="sidebar-divider">

                            <!-- Heading -->
                            <div class="sidebar-heading">
                                Interface
                            </div>

                            <!-- Nav Item - Pages Collapse Menu -->
                            <li class="nav-item">
                                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                                    aria-expanded="true" aria-controls="collapseTwo">
                                    <i class="fas fa-fw fa-cog"></i>
                                    <span>Giới Thiệu Về Ứng Dụng</span>
                                </a>
                                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
                                    data-parent="#accordionSidebar">
                                    <div class="bg-white py-2 collapse-inner rounded">
                                        <h6 class="collapse-header">Về Ứng Dụng</h6>
                                        <a class="collapse-item" href="buttons.html">Đọc Thêm</a>

                                    </div>
                                </div>
                            </li>

                            <li class="nav-item">

                                <a class="nav-link collapsed" href="#" data-toggle="collapse"
                                    data-target="#collapseUtilities" aria-expanded="true"
                                    aria-controls="collapseUtilities">
                                    <i class="fas fa-fw fa-wrench"></i>
                                    <span>Danh Mục Quản Lý</span>
                                </a>
                                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                                    data-parent="#accordionSidebar">
                                    <div class="bg-white py-2 collapse-inner rounded">
                                        <h6 class="collapse-header">Custom Utilities:</h6>
                                        <a class="collapse-item" href="utilities-color.html">Quản Lý Tác Giả</a>
                                        <a class="collapse-item" href="utilities-border.html">Quản Lý Sách</a>
                                        <a class="collapse-item" href="utilities-animation.html">Danh Sách Bạn Đọc</a>
                                        <a class="collapse-item" href="utilities-animation.html">Danh Sách Người
                                            Dùng</a>
                                    </div>
                                </div>

                            </li>

                            <!-- Divider -->
                            <hr class="sidebar-divider">










                        </ul>
                        <!-- End of Sidebar -->

                        <!-- Content Wrapper -->
                        <div id="content-wrapper" class="d-flex flex-column">

                            <!-- Main Content -->
                            <div id="content">

                                <!-- Topbar -->
                                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                                    <!-- Sidebar Toggle (Topbar) -->
                                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                                        <i class="fa fa-bars"></i>
                                    </button>

                                    <!-- Topbar Search -->
                                    <!-- <form
                                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                                        <div class="input-group">
                                            <input type="text" class="form-control bg-light border-0 small"
                                                placeholder="Search for..." aria-label="Search"
                                                aria-describedby="basic-addon2">
                                            <div class="input-group-append">
                                                <button class="btn btn-primary" type="button">
                                                    <i class="fas fa-search fa-sm"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </form> -->

                                    <!-- Topbar Navbar -->
                                    <ul class="navbar-nav ml-auto">

                                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                                        <li class="nav-item dropdown no-arrow d-sm-none">
                                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown"
                                                role="button" data-toggle="dropdown" aria-haspopup="true"
                                                aria-expanded="false">
                                                <i class="fas fa-search fa-fw"></i>
                                            </a>
                                            <!-- Dropdown - Messages -->
                                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                                aria-labelledby="searchDropdown">
                                                <form class="form-inline mr-auto w-100 navbar-search">
                                                    <div class="input-group">
                                                        <input type="text" class="form-control bg-light border-0 small"
                                                            placeholder="Search for..." aria-label="Search"
                                                            aria-describedby="basic-addon2">
                                                        <div class="input-group-append">
                                                            <button class="btn btn-primary" type="button">
                                                                <i class="fas fa-search fa-sm"></i>
                                                            </button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </li>

                                        <!-- Nav Item - Alerts -->


                                        <!-- Nav Item - Messages -->


                                        <div class="topbar-divider d-none d-sm-block"></div>

                                        <!-- Nav Item - User Information -->
                                        <li class="nav-item dropdown no-arrow">
                                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Hi, Quang
                                                    Linh</span>

                                            </a>
                                            <!-- Dropdown - User Information -->
                                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                                aria-labelledby="userDropdown">
                                                <a class="dropdown-item" href="#">
                                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                                    Profile
                                                </a>
                                                <a class="dropdown-item" href="#">
                                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                                    Settings
                                                </a>
                                                <a class="dropdown-item" href="#">
                                                    <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                                    Activity Log
                                                </a>
                                                <div class="dropdown-divider"></div>
                                                <a class="dropdown-item" href="#" data-toggle="modal"
                                                    data-target="#logoutModal">
                                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                                    Logout
                                                </a>
                                            </div>
                                        </li>

                                    </ul>

                                </nav>
                                <!-- End of Topbar -->

                                <!-- Begin Page Content -->
                                <div class="container-fluid">

                                    <!-- Page Heading -->
                                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                                        <h1 class="h3 mb-0 text-gray-800">Table Borrower</h1>

                                    </div>


                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">Id người mượn</th>
                                                <th scope="col">Tên người mượn</th>
                                                <th scope="col">Id sách</th>
                                                <th scope="col">Tên sách</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <c:forEach var="book" items="${dataBooks}">
                                                <tr>
                                                    <th scope="row">${book.user.id}</th>
                                                    <td>${book.user.fullName}</td>
                                                    <td>${book.id}</td>
                                                    <td>${book.name}</td>
                                                </tr>
                                            </c:forEach>


                                        </tbody>
                                    </table>








                                    <!-- Content Row -->
                                    <div class="row">

                                        <!-- Content Column -->
                                        <div class="col-lg-6 mb-4">

                                            <!-- Project Card Example -->
                                            <!-- <div class="card shadow mb-4">
                                                <div class="card-header py-3">
                                                    <h6 class="m-0 font-weight-bold text-primary">Projects</h6>
                                                </div>
                                                <div class="card-body">
                                                    <h4 class="small font-weight-bold">Server Migration <span
                                                            class="float-right">20%</span></h4>
                                                    <div class="progress mb-4">
                                                        <div class="progress-bar bg-danger" role="progressbar"
                                                            style="width: 20%" aria-valuenow="20" aria-valuemin="0"
                                                            aria-valuemax="100"></div>
                                                    </div>
                                                    <h4 class="small font-weight-bold">Sales Tracking <span
                                                            class="float-right">40%</span></h4>
                                                    <div class="progress mb-4">
                                                        <div class="progress-bar bg-warning" role="progressbar"
                                                            style="width: 40%" aria-valuenow="40" aria-valuemin="0"
                                                            aria-valuemax="100"></div>
                                                    </div>
                                                    <h4 class="small font-weight-bold">Customer Database <span
                                                            class="float-right">60%</span></h4>
                                                    <div class="progress mb-4">
                                                        <div class="progress-bar" role="progressbar" style="width: 60%"
                                                            aria-valuenow="60" aria-valuemin="0" aria-valuemax="100">
                                                        </div>
                                                    </div>
                                                    <h4 class="small font-weight-bold">Payout Details <span
                                                            class="float-right">80%</span></h4>
                                                    <div class="progress mb-4">
                                                        <div class="progress-bar bg-info" role="progressbar"
                                                            style="width: 80%" aria-valuenow="80" aria-valuemin="0"
                                                            aria-valuemax="100"></div>
                                                    </div>
                                                    <h4 class="small font-weight-bold">Account Setup <span
                                                            class="float-right">Complete!</span></h4>
                                                    <div class="progress">
                                                        <div class="progress-bar bg-success" role="progressbar"
                                                            style="width: 100%" aria-valuenow="100" aria-valuemin="0"
                                                            aria-valuemax="100"></div>
                                                    </div>
                                                </div>
                                            </div> -->

                                            <!-- Color System -->


                                        </div>

                                        <div class="col-lg-6 mb-4">

                                            <!-- Illustrations -->


                                            <!-- Approach -->


                                        </div>
                                    </div>

                                </div>
                                <!-- /.container-fluid -->

                            </div>
                            <!-- End of Main Content -->

                            <!-- Footer -->
                            <footer class="sticky-footer bg-white">
                                <div class="container my-auto">
                                    <div class="copyright text-center my-auto">
                                        <span>Copyright &copy; Your Website 2021</span>
                                    </div>
                                </div>
                            </footer>
                            <!-- End of Footer -->

                        </div>
                        <!-- End of Content Wrapper -->

                    </div>
                    <!-- End of Page Wrapper -->

                    <!-- Scroll to Top Button-->
                    <a class="scroll-to-top rounded" href="#page-top">
                        <i class="fas fa-angle-up"></i>
                    </a>

                    <!-- Logout Modal-->
                    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
                        aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">×</span>
                                    </button>
                                </div>
                                <div class="modal-body">Select "Logout" below if you are ready to end your current
                                    session.</div>
                                <div class="modal-footer">
                                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                                    <a class="btn btn-primary" href="login.html">Logout</a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Bootstrap core JavaScript-->
                    <script src="/js/jquery.min.js"></script>
                    <script src="/js/bootstrap.bundle.min.js"></script>

                    <!-- Core plugin JavaScript-->
                    <script src="/js/jquery.easing.min.js"></script>

                    <!-- Custom scripts for all pages-->
                    <script src="/js/sb-admin-2.min.js"></script>

                    <!-- Page level plugins -->
                    <script src="/js/Chart.min.js"></script>

                    <!-- Page level custom scripts -->
                    <script src="/js/chart-area-demo.js"></script>
                    <script src="/js/chart-pie-demo.js"></script>

                </body>

                </html>