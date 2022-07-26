# Enunciado

Crie threads para simular o processamento de um pedido.

Apos receber o pedido, o sistema deve executar os seguintes passos:

Processar o pagamento
Verificar e bloquear o estoque
Emitir nota fiscal
Enviar email para o cliente com a nota fiscal
Preparar o produto para expedição
Avisar a transportadora
**OBRIGATORIAMENTE DEVE SER CRIADA UMA THREAD PARA CADA PASSO DA LISTA**

Utilize processamento paralelo, mas algumas regras deve ser seguidas, por exemplo:

O bloqueio do estoque nao pode ocorrer antes do pagamento.
Envio de email da NF nao pode ser executado antes da emissão.
Avisar a transportadora nao pode ocorrer antes de preparar o produto para expedição.
Nota fiscal deve ser emitida logo apos a verificação do estoque.
Preparar o produto para expedição e avisar a transportadora deve ser iniciado logo apos o bloqueio no estoque.
**UTILIZAR APENAS WAIT E NOTIFY PARA GARANTIR O SINCRONISMO**
 Pagamento ->
    Verificação do Estoque->  
        NF -> Email
        Bloqueio do Estoque-> Expedição -> Transportadora 
