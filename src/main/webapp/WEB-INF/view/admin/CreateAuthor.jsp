<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Sử dụng thẻ form của Spring -->
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Table Author</title>
<!-- Custom styles -->
<link href="/css/all.min.css" rel="stylesheet">
<link href="/css/sb-admin-2.min.css" rel="stylesheet">
<!-- Include Bootstrap for responsive layout -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
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
			<div class="container-fluid">
				<!-- Spring Form -->
				<form:form action="/createAuthor/ok" method="post"
					modelAttribute="newAuthor">
					<section class="h-100 bg-dark">
						<div class="container py-5 h-100">
							<div
								class="row d-flex justify-content-center align-items-center h-100">
								<div class="col">
									<div class="card card-registration my-4">
										<div class="row g-0">
											<div class="col-xl-6">
												<div class="card-body p-md-5 text-black">
													<h3 class="mb-5 text-uppercase">Create An Author</h3>

													<!-- Form Input for Full Name -->
													<div class="row">
														<div class="col-md-6 mb-4">
															<div data-mdb-input-init class="form-outline">
																<form:input type="text" id="form3Example1m"
																	class="form-control form-control-lg" path="fullName" />
																<label class="form-label" for="form3Example1m">Full
																	Name of Author</label>
															</div>
														</div>

														<!-- Form Input for Year of Birth -->
														<div class="col-md-6 mb-4">
															<div data-mdb-input-init class="form-outline">
																<form:input type="number" id="form3Example1n"
																	class="form-control form-control-lg" path="born" />
																<label class="form-label" for="form3Example1n">Year
																	of Birth</label>
															</div>
														</div>
													</div>

													<!-- Form Input for Address -->
													<div class="row">
														<div class="col-md-6 mb-4">
															<div data-mdb-input-init class="form-outline">
																<form:input type="text" id="form3Example1m1"
																	class="form-control form-control-lg" path="address" />
																<label class="form-label" for="form3Example1m1">Address</label>
															</div>
														</div>

														<!-- Form Input for Status -->
														<div class="col-md-6 mb-4">
															<div data-mdb-input-init class="form-outline">
																<form:input type="text" id="form3Example1n1"
																	class="form-control form-control-lg" path="status" />
																<label class="form-label" for="form3Example1n1">Status</label>
															</div>
														</div>
													</div>

													<!-- Submit Button -->
													<div class="d-flex justify-content-end pt-3">
														<button type="submit" class="btn btn-warning btn-lg ms-2">Submit
															Form</button>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</section>
				</form:form>

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<%@ include file="footer.jsp"%>
			<!-- End of Footer -->
		</div>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->

	<!-- Include Bootstrap JS and jQuery -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>

</html>
