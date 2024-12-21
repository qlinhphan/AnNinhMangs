<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <title>HTML5 Login Form with validation Example</title>
                    <link rel="stylesheet"
                        href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
                    <link rel="stylesheet" href="/css/style.css">

                </head>

                <body>
                    <!-- partial:index.partial.html -->
                    <div id="login-form-wrap">
                        <h2>Login</h2>
                        <form action="/login" method="post">
                            <div>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            </div>
                            <p>
                                <input type="text" id="username" placeholder="Email Address" style="width: 70%;"
                                    name="username" required /><i class="validation"><span></span><span></span></i>
                            </p>
                            <p>
                                <input type="password" id="password" placeholder="Password"
                                    style="width: 70%; margin-left: 15%;" required name="password" /><i
                                    class="validation"><span></span><span></span></i>
                            </p>
                            <tr>
                                <td>Remember Me:</td>
                                <td><input type="checkbox" name="remember-me" /></td>
                            </tr>
                            <p>
                                <button type="submit">
                                    login
                                </button>
                            </p>
                        </form>
                        <div id="create-account-wrap">
                            <p>Not a member? <a href="#">Create Account</a>
                            <p>
                        </div>
                    </div>


                </body>

                </html>