# DevOps-Untels
Para tener la conexion a play.google.com en tu local (android studio) deberas de generar un jks, poner en donde estas guardando este jks definir un alias y un storepassword:
Para configurar correctamente el secret en el github:

signingKeyBase64: ${{ secrets.SIGNING_KEY }}

    Para obtener el valor del SIGNING_KE tienes que ir al powershell

    # Lee el contenido del archivo de almacén de claves
    $contenido = Get-Content -Path "tu-archivo.jks" -Encoding Byte

    # Codifica el contenido en Base64
    $base64 = [Convert]::ToBase64String($contenido)

    # Muestra el valor codificado en Base64
    Write-Output $base64

    Aqui te mostrara el valor del base64 este es el valor que tiene que guardar en el secret de github actions

alias: ${{ secrets.KEY_ALIAS }}

Al momento de crear al jks en el android studio estos datos deben de ser lo mismo.

keyStorePassword: ${{ secrets.KEY_STORE_PASSWORD }}

Al momento de crear al jks en el android studio estos datos deben de ser lo mismo.

keyPassword: ${{ secrets.KEY_PASSWORD }}

Al momento de crear al jks en el android studio estos datos deben de ser lo mismo.