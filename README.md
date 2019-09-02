# SigaAChave

## Urls Suportadas

#### Usuário

GET - Retorna todos usuários  
`ip:port/usuarios`

GET - Retorna usuario {id}  
`ip:port/usuarios/{id}`

GET - Retornar reservas do Usuario {id}  
`ip:port/usuarios/{id}/reservas`

POST - Adiciona usuario  
`ip:port/usuarios/adicionar/{nome}+{senha}+{papel}`

PUT - Atualiza usuario {id}  
`ip:port/usuarios/{id}/atualizar/{nome}+{senha}+{papel}`

DELETE - Exclui usuario {id}  
`ip:port/usuarios/{id}/excluir`

#### Reservas

GET - Retorna todas reservas  
`ip:port/reservas`

GET - Retorna reserva {id}  
`ip:port/reservas/{id}`

POST - Adiciona reserva  
`ip:port/reservas/adicionar/{sala}+{data}`

PUT - Atualiza reserva {id}  
`ip:port/reservas/{id}/atualizar/{sala}+{data}+{status}`

PUT - Atribui reserva {id} a usuario {usuarioId}  
`ip:port/reservas/{id}/usuario/{usuarioId}`

DELETE - Exclui reserva {id}  
`ip:port/reservas/{id}/excluir`