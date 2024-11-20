<!DOCTYPE html>
<html>
    <head>
        <title>Le Tue Candidature</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
    </head>
    <body>
        <header>
            <h1>Candidature Inviate</h1>
            <hr>
        </header>
        <main>
           <div>
           	<table>
           		<thead>
           			<tr>
           				<th>Azienda</th>
           				<th>Posizione</th>
           				<th>Data Applicazione</th>
           				<th>Note</th>
           			</tr>
           		</thead>
           		<tbody>
                    <#list candidature as candidatura>
                        <tr>
                            <td>${candidatura.azienda}</td>
                            <td>${candidatura.posizione}</td>
                            <td>${candidatura.dataApplicazione}</td>
                            <td>${candidatura.note}</td>
                        </tr>
                    </#list>
                </tbody>
           	</table>
           </div>
        </main>
        <script src="script.js" defer></script> <!-- defer carica lo script in contemporanea alla pagine ma lo esegue solo dopo aver finito di caricarla -->
    </body>
</html>