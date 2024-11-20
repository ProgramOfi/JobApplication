<!DOCTYPE html>
<html>
    <head>
        <title>Convertitore Celsius-Fahrenheit</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
    </head>
    <body>
        <header>
            <h1>JavaScript Converter</h1>
        </header>
        <main>
            <div class="box">
                <h1>Converti da Celsius a Fahrenheit</h1>
                <form action="" id="form">
                    <input type="number" name="celsius" placeholder="celsius">
                    <button class="submit" type="submit">Converti</button>
                </form>
                <div class="result-div" id="result-div"></div>
            </div>
        </main>
        <script src="script.js" defer></script> <!-- defer carica lo script in contemporanea alla pagine ma lo esegue solo dopo aver finito di caricarla -->
    </body>
</html>