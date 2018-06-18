DIRETOR:
(TUDO REFERENTE À TUDO E TODOS)
- Situação de pagamentos dos alunos
- Situação e modificação de pagamento dos professores (ex.: mudar salário)
- Situação de pagamentos em geral (ex.: quantos alunos ainda não pagaram?)

- Situação acadêmica dos alunos (ex.: faltas, notas, advertencias)
- Situação acadêmica dos professores (ex.: turmas lecionadas, formação)

- Recebe e manda mensagens pra geral <<< JAMPA
- Associação de professores <-> matérias <-> salas
- Criação e exclusão de matérias        <<< ZANGADO
- Inclusão e expulsão de alunos e professores       <<< ZANGADO

->  Atributos:
ArrayList Professores (Todos da escola)
ArrayList Alunos (Todos os alunos da escola)

ALUNO:

-> Arraylist Professores (Que ele tem)
-> Diretor

(TUDO REFERENTE A ELE E AOS PROFESSORES QUE ELE TEM)
- Tem um responsável do tipo pessoa (Classe Pessoa vai ser abstrata?)   <<< JAMPA
- Situação acadêmica do aluno
- Recebe e manda mensagens pros professores das matérias atuais     <<< JAMPA
- Quadro de matérias (ementa/descrição das matérias, matrícula em matérias, matérias atuais, sala)
- Emissão de integralização (txt com as infos das matérias do ano todo) <<< ZANGADO

PROFESSOR:

(TUDO REFERENTE ÀS MATÉRIAS QUE ELE LECIONA (incluindo os alunos))   
- Edição de ementa/descrição e etc das matérias que ELE leciona <<< JAMPA
- Quadro de alunos com notas e presenças (editável), fechamento do semestre (aí mostra quem foi aprovado ou não).
- Seta a média das matérias que ele leciona <<< JAMPA
- Recebe e manda mensagem pro aluno e pro diretor   <<< JAMPA



RESPONSAVEL:

Herda de pessoa
atributos: email, telefone, endereço, Aluno
verSituacaoAluno


