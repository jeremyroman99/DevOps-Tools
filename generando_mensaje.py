# Leer el archivo overview.txt
with open('overview.txt', 'r') as file:
    lines = file.readlines()

# Formatear los datos
formatted_lines = []
section = ""
warning = ""
for line in lines:
    line = line.strip()
    
    if line.endswith("warning"):
        warning = line
    elif line.startswith("Correctness") or line.startswith("Performance") or line.startswith("Usability") \
        or line.startswith("Productivity") or line.startswith("Accessibility") or line.startswith("Internationalization"):
        section = line
    elif line.isdigit():
        continue
    else:
        description = line
        formatted_line = f"| {section} | \t{warning} | {description} |"
        formatted_lines.append(formatted_line)

# Agregar encabezados
header_line = "| section | warning | description |"
divider_line = "| ------------- | ------------- | ------------- |"

formatted_lines.insert(0, header_line)
formatted_lines.insert(1, divider_line)

# Escribir los datos formateados en formatted_overview.txt
with open('formatted_overview.txt', 'w') as file:
    for line in formatted_lines:
        file.write(f"{line}\n")

print("Datos formateados y guardados en formatted_overview.txt")
