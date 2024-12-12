<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Table Author</title>
<!-- Custom styles -->
<link href="/css/all.min.css" rel="stylesheet">
<link href="/css/sb-admin-2.min.css" rel="stylesheet">
</head>

<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">
		<!-- Sidebar -->
		<%@ include file="sidebar.jsp"%>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">
				<!-- Topbar -->
				<%@ include file="topbar.jsp"%>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Table Author</h1>
						<a href="/admin/author/create"
							class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
							<i class="fas fa-plus fa-sm text-white-50"></i> Create An Author
						</a>
					</div>

					<!-- Table -->
					<table class="table table-bordered">
						<thead>
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Full Name</th>
								<th scope="col">Born</th>
								<th scope="col">Address</th>
								<th scope="col">Status</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="author" items="${listAuthor}">
								<tr>
									<td>${author.id}</td>
									<td>${author.fullName}</td>
									<td>${author.born}</td>
									<td>${author.address}</td>
									<td>${author.status}</td>
									<td><a href="/admin/author/edit/${author.id}"
										class="btn btn-success btn-sm">Edit</a> <a
										href="/admin/author/delete/${author.id}"
										class="btn btn-danger btn-sm">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- End of Page Content -->
			</div>
			<!-- End of Main Content -->
			<!-- Check if there's a success message -->
			<c:if test="${not empty message}">
				<script>
					Swal.fire({
						title : 'Success!',
						text : "${message}",
						icon : 'success',
						confirmButtonText : 'OK'
					});
				</script>
			</c:if>
			<!-- Footer -->
			<%@ include file="footer.jsp"%>
			<!-- End of Footer -->
		</div>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->

</body>

</html>