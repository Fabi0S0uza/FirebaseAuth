#FireAuth - Firebase Authentication App
Projeto de Autenticação Firebase para Android
Descrição do Projeto
O FireAuth é um aplicativo Android nativo desenvolvido em Java que utiliza o Firebase Authentication para gerenciar autenticação de usuários via email e senha. O app permite que os usuários façam login, registrem novas contas, e façam logout com facilidade, garantindo um gerenciamento de sessão seguro e uma navegação suave entre as telas.

Tecnologias Utilizadas
Linguagem: Java (Android Nativo)
Plataforma: Android
Banco de Dados: Firebase Authentication
IDE: Android Studio
Funcionalidades
1. Tela de Login
Entrada de email e senha.
Autenticação via FirebaseAuth.signInWithEmailAndPassword.
Mensagem de erro exibida em caso de falha (senha incorreta ou usuário inexistente).
Redirecionamento para a tela de sucesso (LogadoActivity) após login bem-sucedido.
2. Tela de Registro
Botão para navegar até a tela de registro (RegisterActivity).
Registro de novos usuários via FirebaseAuth.createUserWithEmailAndPassword.
Login disponível imediatamente após o registro bem-sucedido.
3. Logout
Opção de logout na tela LogadoActivity.
Uso de FirebaseAuth.signOut() para desconectar o usuário e redirecionar de volta à tela de login (MainActivity).
4. Exibição de Dados do Usuário
Exibe o email do usuário logado através de uma TextView na LogadoActivity.
Dados obtidos com FirebaseUser.getEmail().
Estrutura de Códigos e Classes
1. MainActivity (Tela de Login)
Componentes:
Campos de entrada (EditText) para email e senha.
Botão de login e botão para navegação à tela de registro.
Método:
loginUser: Autentica o usuário com o Firebase e o redireciona após login bem-sucedido.
2. RegisterActivity (Tela de Registro)
Componentes:
Funcionalidade para registrar novos usuários via Firebase.
Login habilitado logo após o registro.
3. LogadoActivity (Tela Após Login)
Componentes:
Exibe o email do usuário logado em uma TextView.
Botão de logout que desloga o usuário e redireciona de volta para a tela de login.
Firebase Authentication
Configuração:
Firebase integrado ao projeto utilizando o arquivo google-services.json.
Autenticação por email e senha configurada no Firebase Console.
Métodos de Autenticação:
Login e logout implementados com segurança utilizando a API do Firebase Authentication.
Pontos Fortes
Integração Simples com Firebase: A implementação segue boas práticas, garantindo fácil manutenção e entendimento.
Navegação Suave: Alternância eficiente entre as telas de login, registro e sessão logada.
Gerenciamento de Sessão: Login e logout funcionam corretamente, mantendo o estado do usuário durante a sessão.
Sugestões de Melhorias Futuras
1. Validação de Entradas:
Verificar se o email tem um formato válido.
Garantir que a senha possua um número mínimo de caracteres.
2. Persistência de Sessão:
Verificar se o usuário já está autenticado ao abrir o aplicativo, redirecionando diretamente para a LogadoActivity se estiver logado.
3. Feedback Visual:
Adicionar um indicador de progresso (como um ProgressBar) durante as operações de login e registro.
4. Recuperação de Senha:
Implementar a função de recuperação de senha via FirebaseAuth.sendPasswordResetEmail.
Conclusão
O aplicativo FireAuth é uma implementação funcional de autenticação de usuários com o Firebase. Com uma interface simples e navegação intuitiva, ele gerencia as sessões de forma eficaz. Pequenas melhorias podem refinar ainda mais a experiência do usuário, como validações mais robustas e feedback visual.
