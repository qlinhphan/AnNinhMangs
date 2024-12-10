<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Delete Author</title>
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
			<div class="container-fluid">
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Delete Author</h6>
					</div>
					<div class="card-body">
						<p>Are you sure you want to delete the following author?</p>
						<form:form action="/deleteAuthor/ok" method="post"
							modelAttribute="currentAuthor">
							<div class="form-group" style="display: none;">
								<form:input type="text" path="id" class="form-control" />
							</div>
							<div class="form-group">
								<label>Full Name:</label>
								<form:input type="text" path="fullName" class="form-control"
									readonly="true" />
							</div>
							<div class="form-group">
								<label>Year of Birth:</label>
								<form:input type="text" path="born" class="form-control"
									readonly="true" />
							</div>
							<div class="form-group">
								<label>Address:</label>
								<form:input type="text" path="address" class="form-control"
									readonly="true" />
							</div>
							<div class="form-group">
								<label>Status:</label>
								<form:input type="text" path="status" class="form-control"
									readonly="true" />
							</div>

							<!-- Buttons -->
							<div class="d-flex justify-content-end">
								<a href="/admin/author" class="btn btn-secondary">Cancel</a>
								<button type="submit" class="btn btn-danger ml-3">Confirm
									Delete</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
			<!-- End of Main Content -->
			<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
			<!-- SweetAlert2 -->
			<script>
    document.querySelector('form').addEventListener('submit', function(event) {
        event.preventDefault(); // Ngăn chặn hành động mặc định của form
        const formData = new FormData(this);
        fetch('/deleteAuthor/ok', {
            method: 'POST',
            body: formData,
        })
        .then(response => {
            if (response.ok) {
                Swal.fire({
                    title: 'Success!',
                    text: 'Author deleted successfully!',
                    icon: 'success',
                    confirmButtonText: 'OK'
                }).then(() => {
                    window.location.href = '/admin/author'; // Chuyển hướng về danh sách
                });
            } else {
                Swal.fire({
                    title: 'Error!',
                    text: 'Failed to delete author.',
                    icon: 'error',
                    confirmButtonText: 'OK'
                });
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
    });
</script>


			<!-- Footer -->
			<%@ include file="footer.jsp"%>
			<!-- End of Footer -->
		</div>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->
</body>

</html>
