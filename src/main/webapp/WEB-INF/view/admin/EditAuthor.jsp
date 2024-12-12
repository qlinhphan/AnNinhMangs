<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Author</title>
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
                <!-- Form for editing author -->
                <form:form action="/editAuthor/ok" method="post" modelAttribute="currentAuthor">
                    <!-- Hidden field for Author ID -->
                    <div class="form-group" style="display: none;">
                        <label for="authorId">ID</label>
                        <form:input type="text" class="form-control" id="authorId" path="id" />
                    </div>

                    <!-- Input field for Full Name -->
                    <div class="form-group">
                        <label for="fullName">Full Name</label>
                        <form:input type="text" class="form-control" id="fullName" path="fullName"
                                    placeholder="Enter Full Name of Author" />
                    </div>

                    <!-- Input field for Year of Birth -->
                    <div class="form-group">
                        <label for="born">Year of Birth</label>
                        <form:input type="number" class="form-control" id="born" path="born"
                                    placeholder="Enter Year of Birth" />
                    </div>

                    <!-- Input field for Address -->
                    <div class="form-group">
                        <label for="address">Address</label>
                        <form:input type="text" class="form-control" id="address" path="address"
                                    placeholder="Enter Address" />
                    </div>

                    <!-- Input field for Status -->
                    <div class="form-group">
                        <label for="status">Status</label>
                        <form:input type="text" class="form-control" id="status" path="status"
                                    placeholder="Enter Status" />
                    </div>

                    <!-- Submit Button -->
                    <button type="submit" class="btn btn-primary">Update Author</button>
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
</body>

</html>
