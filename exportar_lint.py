from bs4 import BeautifulSoup

# Leer el contenido del archivo HTML
with open('app/build/reports/lint-results-debug.html', 'r', encoding='utf-8') as file:
    html_content = file.read()

# Parsear el HTML con BeautifulSoup
soup = BeautifulSoup(html_content, 'html.parser')

# Buscar la tabla con la clase "overview"
table = soup.find('table', {'class': 'overview'})

# Verificar si se encontró la tabla
if table:
    # Crear o abrir un archivo de texto para escribir
    with open('overview.txt', 'w', encoding='utf-8') as f:
        # Recorrer cada fila de la tabla
        for row in table.find_all('tr'):
            # Obtener las celdas de la fila
            cells = row.find_all(['td', 'th'])
            
            # Escribir cada celda en el archivo de texto
            for cell in cells:
                f.write(cell.text.strip() + '\t')
            f.write('\n')
    
    print('Tabla exportada a overview.txt')
else:
    print('No se encontró la tabla con la clase "overview" en el archivo lint-results-debug.html')
