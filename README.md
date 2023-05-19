# SisInf-SV2223-G9

# SEGUNDA FASE

    Resultados pretendidos
    
Tendo em conta os objetivos de aprendizagem, deverão ser produzidos os seguintes resultados:
  1. Criação de uma aplicação Java que permita:
    (a) Aceder às funcionalidades 2d a 2l, descritas na fase 1 deste trabalho;
    (b) Realizar a funcionalidade 2h, descrita na fase 1 deste trabalho, sem usar qualquer
    procedimento armazenado nem qualquer função pgSql;
    (c) Realizar a funcionalidade 2h, descrita na fase 1 deste trabalho, reutilizando os
    procedimentos armazenados e funções que a funcionalidade original usa;
  2.
    (a) Usando optimistic locking, aumentar em 20% o número de pontos associados a um
    crachá, dados o nome do crachá e o identificador do jogo a que ele pertence.
    (b) testar a alínea anterior, apresentando uma mensagem de erro adequada em caso de
    alteração concorrente conflituante que inviabilize a operação. No relatório deve estar
    descrita a forma como as situações de erro foram criadas para teste desta alínea;
    (c) realizar o mesmo que em (a), mas usando controlo de concorrência pessimista.
  
  Notas:
    Todas as alíneas devem ter tratamento de erros e, nos casos relevantes, gestão transacional
    utilizando o nível de isolamento adequado de forma explícita.
    O código a desenvolver deverá estar organizado em vários projetos que reflitam a estrutura
    modular da aplicação, a qual deverá reduzir o acoplamento entre módulos e facilitar a
    identificação das dependências entre eles.
