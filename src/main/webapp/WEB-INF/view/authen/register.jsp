<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                <!DOCTYPE html>
                <!-- Coding By CodingNepal - codingnepalweb.com -->
                <html lang="en">

                <head>
                    <meta charset="UTF-8" />
                    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                    <title>Email and Password Validation</title>

                    <!-- CSS -->
                    <link rel="stylesheet" href="/css/main.css">

                    <!-- Boxicons CSS -->
                    <link href="https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css" rel="stylesheet" />

                </head>

                <body>
                    <div class="container">
                        <header>Signup</header>
                        <form:form action="/register" method="post" modelAttribute="newRegis">
                            <!-- <div>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            </div> -->
                            <div class="field">


                                <div class="input-field">
                                    <form:input type="text" placeholder="Enter your Name" class="email" path="name" />
                                </div>
                                <span class="error email-error">
                                    <i class="bx bx-error-circle error-icon"></i>
                                    <p class="error-text">Please enter a valid name</p>
                                </span>
                            </div>
                            <div class="field email-field">
                                <div class="input-field">
                                    <form:input type="email" placeholder="Enter your email" class="email"
                                        path="email" />
                                </div>
                                <span class="error email-error">
                                    <i class="bx bx-error-circle error-icon"></i>
                                    <p class="error-text">Please enter a valid email</p>
                                </span>
                            </div>
                            <div class="field create-password">
                                <div class="input-field">
                                    <form:input type="password" placeholder="Create password" class="password"
                                        path="password" />
                                    <i class="bx bx-hide show-hide"></i>
                                </div>
                                <span class="error password-error">
                                    <i class="bx bx-error-circle error-icon"></i>
                                    <p class="error-text">
                                        Please enter atleast 8 charatcer with number, symbol, small and
                                        capital letter.
                                    </p>
                                </span>
                            </div>
                            <div class="field confirm-password">
                                <div class="input-field">
                                    <form:input type="password" placeholder="Confirm password" class="cPassword"
                                        path="rePassword" />
                                    <i class="bx bx-hide show-hide"></i>
                                </div>
                                <span class="error cPassword-error">
                                    <i class="bx bx-error-circle error-icon"></i>
                                    <p class="error-text">Password don't match</p>
                                </span>
                            </div>
                            <div class="input-field button">
                                <button type="submit">Submit</button>
                            </div>
                            <div>
                                <p>Bạn đã có tài khoản? <a href="/login">Login now</a></p>
                            </div>
                        </form:form>
                    </div>

                    <!-- JavaScript -->
                    <script src="/js/let.js"></script>
                </body>

                </html>