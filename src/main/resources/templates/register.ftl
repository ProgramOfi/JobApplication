<!DOCTYPE html>
<html>
<head>
    <title>Registrati</title>
</head>
<body>
    <h1>Registrati</h1>
    <form action="/register" method="post">
    	<input type="hidden" name="_csrf" value="${_csrf.token}" />
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" required>
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <button type="submit">Registrati</button>
    </form>
</body>
</html>