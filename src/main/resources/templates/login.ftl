<!DOCTYPE html>
<html lang="it">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login - Job Application</title>
        <link rel="stylesheet" href="/css/login.css">
    </head>
    <body>
        <div class="container">
            <div id="form_login">
                <div class="card">
                    <h1>Benvenuto!</h1>
                    <form action="/login" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <div id="errorMessage">
                        Username o password errati!
                    </div>
                    <input type="text" placeholder="Username" id="username" name="username" required>
                    <br>
                    <input type="password" placeholder="Password" id="password" name="password" required>
                    <br>
                    <button type="submit" class="login">
                        <span>Login</span>
                    </button>
                    <br>
                    <button class="register" onclick="window.location.href='/register';"><span>Registrati</span></button>
                    </form>
                </div>
            </div>
        </div>
        <script src="/js/login.js"></script>
    </body>
</html>