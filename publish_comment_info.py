import json
import os
from github import Github

# Obtener el token de GitHub
github_token = os.environ['GITHUB_TOKEN']

# Crear una instancia de la clase Github
g = Github(github_token)

# Obtener el número del pull request desde el archivo de evento
with open(os.environ['GITHUB_EVENT_PATH'], 'r') as f:
    event_data = json.load(f)
    pr_number = event_data['pull_request']['number']

# Obtener el contexto del repositorio
repository = os.environ['GITHUB_REPOSITORY']
repo = g.get_repo(repository)

# Leer el número de errores y advertencias del lint
lint_errors = os.environ.get('LINT_ERRORS', 'N/A')
lint_warnings = os.environ.get('LINT_WARNINGS', 'N/A')

github_run_id = os.environ['GITHUB_RUN_ID']

# Crear el cuerpo del comentario con el número de errores y advertencias
comment_body = f"Reporte de Lint:\nNúmero de errores: {lint_errors}\nNúmero de advertencias: {lint_warnings}\n Para descargar el reporte completo de las pruebas lint ir al apartado de Artifacts : https://github.com/jeremyroman99/DevOps-Tools/actions/runs/{github_run_id}"

# Publicar el comentario en el pull request
pr = repo.get_pull(int(pr_number))
pr.create_issue_comment(comment_body)