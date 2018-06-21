DIRETOR:
(TUDO REFERENTE À TUDO E TODOS)
- Situação de pagamentos dos alunos
- Situação e modificação de pagamento dos professores (ex.: mudar salário)
- Situação de pagamentos em geral (ex.: quantos alunos ainda não pagaram?)

- Situação acadêmica dos alunos (ex.: faltas, notas, advertencias)
- Situação acadêmica dos professores (ex.: turmas lecionadas, formação)

- Recebe e manda mensagens pra geral <<< JAMPA  *******FALTA EXCECAO PESSOA NAO ENCONTRADA
- Associação de professores <-> matérias <-> salas <<<< Feito por alguem,******* FALTA EXCECOES
- [DONE] Criação e exclusão de matérias        <<< ZANGADO
- Inclusão e expulsão de alunos e professores  <<< ZANGADO *****EXCECOES ALUNO/PROF NAO ENCONTRADO


->  Atributos:
ArrayList Professores (Todos da escola)
ArrayList Alunos (Todos os alunos da escola)

ALUNO:

-> Diretor

(TUDO REFERENTE A ELE E AOS PROFESSORES QUE ELE TEM)
- Situação acadêmica do aluno
- Recebe e manda mensagens pros professores das matérias atuais  <<< JAMPA ******EXCECOES AL/PROF N ENCONTRADO
- Quadro de matérias (ementa/descrição das matérias, matrícula em matérias, matérias atuais, sala)
- Emissão de integralização (txt com as infos das matérias do ano todo) <<< ZANGADO

PROFESSOR:

(TUDO REFERENTE ÀS MATÉRIAS QUE ELE LECIONA (incluindo os alunos))   
- [DONE] Edição de ementa/descrição e etc das matérias que ELE leciona COM EXCECAO<<< JAMPA
- Quadro de alunos com notas e presenças (editável), fechamento do semestre (aí mostra quem foi aprovado ou não).
- [BUG] Seta a média das matérias que ele leciona <<< JAMPA ******EXCE: MATERIA N ENCONTRADA
- Recebe e manda mensagem pro aluno e pro diretor   <<< JAMPA  *******EXCE: AL/DIR N ENCONTRADO



//DECIDIMOS NAO USAR RESPONSAVEL
RESPONSAVEL:

Herda de pessoa
atributos: email, telefone, endereço, Aluno
verSituacaoAluno


