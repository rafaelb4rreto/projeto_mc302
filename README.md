DIRETOR:
(TUDO REFERENTE À TUDO E TODOS)
- Situação de pagamentos dos alunos
- Situação e modificação de pagamento dos professores (ex.: mudar salário)
- Situação de pagamentos em geral (ex.: quantos alunos ainda não pagaram?)

- Situação acadêmica dos alunos (ex.: faltas, notas, advertencias)
- Situação acadêmica dos professores (ex.: turmas lecionadas, formação)

- [DONE] Recebe e manda mensagens pra geral <<< JAMPA
- [DONE] Associação de professores <-> matérias <-> salas
- [DONE] Criação e exclusão de matérias        <<< ZANGADO
- [DONE] Inclusão e expulsão de alunos e professores       <<< ZANGADO


->  Atributos:
ArrayList Professores (Todos da escola)
ArrayList Alunos (Todos os alunos da escola)

ALUNO:

-> Arraylist Professores (Que ele tem)
-> Diretor

(TUDO REFERENTE A ELE E AOS PROFESSORES QUE ELE TEM)
- Situação acadêmica do aluno
- [DONE] Recebe e manda mensagens pros professores das matérias atuais     <<< JAMPA
- Quadro de matérias (ementa/descrição das matérias, matrícula em matérias, matérias atuais, sala)
- Emissão de integralização (txt com as infos das matérias do ano todo) <<< ZANGADO
- Balanço do aluno

PROFESSOR:

(TUDO REFERENTE ÀS MATÉRIAS QUE ELE LECIONA (incluindo os alunos))   
- [DONE] Edição de ementa/descrição e etc das matérias que ELE leciona <<< JAMPA
- Quadro de alunos com notas e presenças (editável), fechamento do semestre (aí mostra quem foi aprovado ou não).
- Seta a média das matérias que ele leciona <<< JAMPA
- [DONE] Recebe e manda mensagem pro aluno e pro diretor   <<< JAMPA



RESPONSAVEL:

Herda de pessoa
atributos: email, telefone, endereço, Aluno
verSituacaoAluno

Interface Gráfica:

- Mensagens
- Horario
- Login
- Notas

