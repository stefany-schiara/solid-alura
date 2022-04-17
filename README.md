# solid-alura

Single Responsibility Principle - Principio da responsabilidade única.
Open Closed Principle - Principio aberto e fechado.
Liskov Substitution Principle - Principio da substituição de Liskov.
Interface Segreation Principle - Principio de segregação de Interface.
Dependency Inversion Principle - Principio de inversão de dependências.

---
Coesão - Em termos de classe, uma classe coesa é conter atributos e métodos pertinentes, por exemplo,
uma classe Funcionario, deve ter somente atributos e métodos referente à um funcionário. A classe deve ter uma única responsabilidade.

Encapsulamento - "Proteger algo", "Colocar dentro de uma capsula".
Os métodos getters e setters por si só não garantem o encapsulando, por exemplo, se tenho a classe funcionário
e nela existe um atributo "salário", se eu gero os getters e setters, posso por exemplo de qualquer lugar "burlar" uma regra de negócio, posso simplesmente fazer um funcionario.setSalario(1000000) e setar o valor que eu quiser. Para mitigar isso, podemos colocar a regra no método setter, ou deixar o atributo privado e manter a regra de negocio dentro da própria classe.

Acoplamento - "Ação de acoplar, agrupamento aos pares"
O Acoplamento acontece quando uma classe chama a outra. Um bom acoplamento é quando eu não sofro quando preciso alterar uma das classes envolvidas.
Exemplo:
Tenho uma classe Funcionario e outra Reajuste, na classe Reajuste, existe um cálculo, o bom acoplamento é quando eu preciso receber por exemplo um valor de reajuste, eu chamo um método da classe reajuste e atribuo à um BigDecimal da classe funcionário, caso haja uma alteração no cálculo do reajuste, eu só me preocupo em alterar na própria classe de Reajuste, sem ter que alterar a classe Funcionario.

---

O S - está diretamente ligado à coesão, a classe ter somente uma responsabilidade, tratar apenas do mesmo "assunto".

O O  - "Entidades de software (classes, módulos, funções, etc.) devem estar abertas para extensão, porém fechadas para modificação" - Um exemplo é: "Você não precisa realizar uma cirurgia de corpo aberto apenas para colocar um casaco", esse exemplo quer dizer no contexto sistêmico, que para adicionar novas implementações no seu código, você não tem que mexer em tudo, basta adicionar algo novo sem comprometimento do funcionamento "do todo".
Cada classe deve conhecer e ser responsável por suas próprias regras de negócio.
-
- Uma classe que tende a crescer "para sempre" é uma forte candidata a sofrer alguma espécie de refatoração.

O L  - Fala sobre heranças e tem uma frase como uma metáfora para exemplificar a situação "Se parece com um pato, faz "quack" como um pato, mas precisa de pilhas , há algo errado na abstração". Como vimos no exemplo da classe "Terceiros" que herdava os atributos da classe "Funcionario", porém nem todos comportamentos e atributos da classe funcionário servem para a classe terceiros.  Esse princípio está mais relacionado a herança.
- embora a herança favoreça o reaproveitamento de código, ela pode trazer efeitos colaterais quando não utilizada da maneira correta;
- Que o Princípio de Substituição de Liskov (LSP) diz que devemos poder substituir classes base por suas classes derivadas em qualquer lugar, sem problema.

O I  - "Uma classe não deveria ser forçada a depender de métodos que não utilizará". Uma saída para resolver isso, é criar uma nova interface com o método isolado que será utilizado em um caso especifico, então, a interface "secundaria" extends a principal.
Por exemplo, existe um tipo de tributação apenas para um caso especifico de reajuste de salario, para outros reajustes, eu não preciso do método de calculo de tributação.
Então faço: Já existe a interface Reajuste > A classe Anuenio, não há tributação ela implementa os métodos da interface Reajuste.
Tem a classe Promocao que ela sim existe uma tributação e ela também implementava a interface Reajuste.
Nós criamos uma interface ReajusteTributavel, contendo apenas o método especifico. e ficará da seguinte forma:
Anuenio > implements Reajuste
Promocao > implements ReajusteTributavel
ReajusteTributavel > extends Reajuste

O D - Fala sobre implementações depender de abstrações(por exemplo uma interface é uma abstração) e não uma abstração depender de uma implementação.
O exemplo dado foi: Se vc já tem uma casa e toda sua estrutura elétrica montada, quando vc deseja instalar uma lâmpada, você não liga uma lâmpada na tomada e conecta fios à ela, você apenas encaixa no bocal. Nesse exemplo, a lâmpada representa uma implementação e o bocal uma abstração. Ao implementar o O no solid, já meio que somos induzido à implementar numa tacada só os princípios S O D.
Resumindo, temos vantagens em depender de interfaces e não de implementações. Caso uma determinada implementação mude, não seremos afetados, pois dependemos somente de sua interface. Se um método muda  a forma como realiza sua tarefa, desde que a interface se mantenha, não vamos precisar nem ter a preocupação de editar nosso código.

---

PARA RESUMIR


- Que é mais interessante e mais seguro para o nosso código depender de interfaces (classes abstratas, assinaturas de métodos e interfaces em si) do que das implementações de uma classe;
- Que as interfaces são menos propensas a sofrer mudanças enquanto implementações podem mudar a qualquer momento;
- Que o Princípio de Inversão de Dependência (DIP) diz que implementações devem depender de abstrações e abstrações não devem depender de implementações;
- Que as interfaces devem definir apenas os métodos que fazem sentido para seu contexto;
- Que o Princípio de Segregação de Interfaces (ISP) diz que uma classe não deve ser obrigada a implementar um método que ela não precisa;
- Os conceitos aprendidos neste treinamento formam o acrônimo SOLID
    - Single Responsibility Principle
    - Open Closed Principle
    - Liskov Substitution Principle
    - Interface Segregation Principle
    - Dependency Inversion Principle