import requests
from tkinter import *

def cadastrarAluno():
    m = matricula_entry.get()
    n = nome_entry.get()
    c = cpf_entry.get()
    e = endereco_entry.get()

    url = "http://localhost:8080/api/aluno/cadastroAluno"
    PARAMS = {'matricula': m, 'nome': n, 'cpf': c, 'endereco': e}
    response = requests.post(url, params=PARAMS)

    if response.status_code == 200:
        print("Aluno cadastrado com sucesso!")
        aluno_cadastro_window.destroy()
    else:
        print(f"Erro ao cadastrar aluno: {response.status_code}")

def cadastrarLivro():
    d = disponivel_entry.get()
    e = exemplar_entry.get()
    p = prazo_entry.get()
    i = isbn_entry.get()
    ed = editora_entry.get()

    d = True if d.lower() == 's' else False
    e = True if e.lower() == 's' else False
    p = int(p) if p else None

    url = "http://localhost:8080/api/livro/cadastroLivro"
    PARAMS = {'disponivel': d, 'exemplarBiblioteca': e, 'prazo': p, 'isbn': i, 'editora': ed}
    response = requests.post(url, params=PARAMS)

    if response.status_code == 200:
        print("Livro cadastrado com sucesso!")
        livro_cadastro_window.destroy()
    else:
        print(f"Erro ao cadastrar livro: {response.status_code}")

def verificaAluno():
    m = matricula_entry.get()

    url = f"http://localhost:8080/api/aluno/matricula?matricula={m}"
    response = requests.get(url)

    if response.status_code == 200:
        print("Aluno verificado com sucesso!")
        openAlunoOptionsWindow()
    else:
        print(f"Erro ao verificar aluno: {response.status_code}")

def listaLivros():
    url = f"http://localhost:8080/api/livro"
    response = requests.get(url)

    if response.status_code == 200:  # Verifica se a requisição foi bem-sucedida
        livros = response.json()  # Extrai os dados da resposta
        livros_text.delete('1.0', END)
        for livro in livros:
            disponivel = 'Sim' if livro['disponivel'] else 'Não'
            exemplarBiblioteca = 'Sim' if livro['exemplarBiblioteca'] else 'Não'
            livros_text.insert(END, f"ID: {livro['id']}\n")
            livros_text.insert(END, f"Disponível: {disponivel}\n")
            livros_text.insert(END, f"Exemplar da Biblioteca: {exemplarBiblioteca}\n")
            livros_text.insert(END, f"Editora: {livro['titulo']['editora']}\n")
            livros_text.insert(END, f"Prazo de devolução: {livro['titulo']['prazo']} dias\n")
            livros_text.insert(END, f"Isbn do livro: {livro['titulo']['isbn']}\n")
            livros_text.insert(END, "------------------------\n")
        return livros  # Retorna os dados
    else:
        print(f"Erro ao listar livros: {response.status_code}")
        return None

def openAlunoCadastroWindow():
    global aluno_cadastro_window
    aluno_cadastro_window = Toplevel(root)
    aluno_cadastro_window.title("Cadastrar Aluno")

    global matricula_entry, nome_entry, cpf_entry, endereco_entry
    Label(aluno_cadastro_window, text="Matrícula").grid(row=0)
    matricula_entry = Entry(aluno_cadastro_window)
    matricula_entry.grid(row=0, column=1)

    Label(aluno_cadastro_window, text="Nome").grid(row=1)
    nome_entry = Entry(aluno_cadastro_window)
    nome_entry.grid(row=1, column=1)

    Label(aluno_cadastro_window, text="CPF").grid(row=2)
    cpf_entry = Entry(aluno_cadastro_window)
    cpf_entry.grid(row=2, column=1)

    Label(aluno_cadastro_window, text="Endereço").grid(row=3)
    endereco_entry = Entry(aluno_cadastro_window)
    endereco_entry.grid(row=3, column=1)

    Button(aluno_cadastro_window, text="Cadastrar Aluno", command=cadastrarAluno).grid(row=4, column=0)

def openLivroCadastroWindow():
    global livro_cadastro_window
    livro_cadastro_window = Toplevel(root)
    livro_cadastro_window.title("Cadastrar Livro")

    global disponivel_entry, exemplar_entry, prazo_entry, isbn_entry, editora_entry
    Label(livro_cadastro_window, text="Disponível").grid(row=0)
    disponivel_entry = Entry(livro_cadastro_window)
    disponivel_entry.grid(row=0, column=1)

    Label(livro_cadastro_window, text="Exemplar da Biblioteca").grid(row=1)
    exemplar_entry = Entry(livro_cadastro_window)
    exemplar_entry.grid(row=1, column=1)

    Label(livro_cadastro_window, text="Prazo").grid(row=2)
    prazo_entry = Entry(livro_cadastro_window)
    prazo_entry.grid(row=2, column=1)

    Label(livro_cadastro_window, text="ISBN").grid(row=3)
    isbn_entry = Entry(livro_cadastro_window)
    isbn_entry.grid(row=3, column=1)

    Label(livro_cadastro_window, text="Editora").grid(row=4)
    editora_entry = Entry(livro_cadastro_window)
    editora_entry.grid(row=4, column=1)

    Button(livro_cadastro_window, text="Cadastrar Livro", command=cadastrarLivro).grid(row=5, column=0)

def openAlunoWindow():
    aluno_window = Toplevel(root)
    aluno_window.title("Entrar como Aluno")


    global matricula_entry
    Label(aluno_window, text="Matrícula").grid(row=0)
    matricula_entry = Entry(aluno_window)
    matricula_entry.grid(row=0, column=1)

    Button(aluno_window, text="Entrar", command=verificaAluno).grid(row=1, column=0)

def openBibliotecarioWindow():
    bibliotecario_window = Toplevel(root)
    bibliotecario_window.title("Entrar como Bibliotecário")

    Button(bibliotecario_window, text="Cadastrar Aluno", command=openAlunoCadastroWindow).grid(row=0, column=0)
    Button(bibliotecario_window, text="Cadastrar Livro", command=openLivroCadastroWindow).grid(row=0, column=1)

def openAlunoOptionsWindow():
    aluno_options_window = Toplevel(root)
    aluno_options_window.title("Opções do Aluno")

    global livros_text
    Button(aluno_options_window, text="Listar Livros", command=listaLivros).grid(row=0, column=0)

    livros_text = Text(aluno_options_window, height=10, width=50)
    livros_text.grid(row=1, column=0, columnspan=3)

root = Tk()
Button(root, text="Entrar como Aluno", command=openAlunoWindow).grid(row=0, column=0, padx=20)
Button(root, text="Entrar como Bibliotecário", command=openBibliotecarioWindow).grid(row=0, column=1, padx=20)
root.mainloop()
