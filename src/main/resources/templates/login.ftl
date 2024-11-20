<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form action="/login" method="post">
    	<input type="hidden" name="_csrf" value="${_csrf.token}" />
    	<div id="errorMessage" style="color: red; display: none;">
            Username o password errati!
        </div>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <button type="submit">Login</button>
        <button class="register" onclick="window.location.href='/register';">Registrati</button>
    </form>
    <script>
        // Se la query parameter "error" è presente nella URL, mostriamo il messaggio di errore
        if (window.location.search.indexOf("error") !== -1) {
            document.getElementById("errorMessage").style.display = "block";
        }
    </script>
</body>
</html>