import requests

def cadastrarAluno(m,n,c,e):
    url = "http://localhost:8080/api/aluno/cadastroAluno"

    PARAMS = {'matricula': m, 'nome': n, 'cpf': c, 'endereco': e}

    response = requests.post(url, params=PARAMS)

    if response.status_code == 200:
        print("Aluno cadastrado com sucesso!")
    else:
        print(f"Erro ao cadastrar aluno: {response.status_code}")

def cadastrarLivro(d,e,p,tid,i,ed):
    url1 = "http://localhost:8080/api/livro/cadastroLivro"
    url2 = "http://localhost:8080/api/titulo/cadastroTitulo"

    PARAMS1 = {'disponivel': d, 'exemplarBibilioteca': e,'titulo_id': tid}
    PARAMS2 = {'prazo': p, 'isbn': i, 'editora': ed}

    response1 = requests.post(url1, params=PARAMS1)
    response2 = requests.post(url2, params=PARAMS2)

    if response1.status_code == 200 and response2.status_code == 200:
        print("Livro cadastrado com sucesso!")
    else:
        print(f"Erro ao cadastrar aluno: {response1.status_code} {response2.status_code}")



print('---------Bem vindo a biblioteca!----------\n')


x=int(input("1-Entrar como aluno   2-Entrar como bibliotecario\n"))

if x == 1: 
    print('logar')
if x == 2:
    y=int(input('1-Cadastrar aluno     2-Cadastrar livro\n'))
    if y == 1:
        m = input("Insira a matricula do aluno: \n")
        n = input("Insira o nome do aluno: \n")
        c = input("Insira o cpf do aluno: \n")
        e = input("Insira o endereco do aluno: \n")
        cadastrarAluno(m,n,c,e)
    if y == 2:
        d = input("O livro esta disponivel? S ou N: \n")
        if d == 'S':
            d = True
        else:
            d = False

        e = input("O livro e um exemplar da bibilioteca? S ou N: \n")
        if e == 'S':
            e = True
        else:
            e = False
        tid = int(input("Titulo id?:\n"))
        p = int(input("Qual o prazo de devolucao do livro em dias?"))
        i = input("Qual o isbn do livro?: \n")
        ed = input("Qual a editora do livro?: \n")

        cadastrarLivro(d,e,p,tid,i,ed)
