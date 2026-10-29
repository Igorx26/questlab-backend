-- =================================================================================
-- 1. TABELAS INDEPENDENTES (Sem Chaves Estrangeiras Obrigatórias para Criação)
-- =================================================================================

-- Tabela: disciplinaModel
INSERT INTO disciplina (id, nome) VALUES
(1, 'Língua Portuguesa'), (2, 'Matemática'), (3, 'Raciocínio Lógico'), (4, 'Direito Constitucional'), (5, 'Direito Administrativo'),
(6, 'Informática'), (7, 'Inglês'), (8, 'Gestão Pública'), (9, 'Arquivologia'), (10, 'Contabilidade Geral'),
(11, 'Economia'), (12, 'Estatística'), (13, 'Direito Penal'), (14, 'Direito Processual Penal'), (15, 'Direito Civil'),
(16, 'Direito Processual Civil'), (17, 'Direito Tributário'), (18, 'Direito Empresarial'), (19, 'Direito do Trabalho'), (20, 'Processo do Trabalho'),
(21, 'Direito Previdenciário'), (22, 'Direito Eleitoral'), (23, 'Direito Ambiental'), (24, 'Direito do Consumidor'), (25, 'Direitos Humanos'),
(26, 'Ética no Serviço Público'), (27, 'Administração Geral'), (28, 'Administração Financeira'), (29, 'Contabilidade Pública'), (30, 'Auditoria'),
(31, 'Banco de Dados'), (32, 'Engenharia de Software'), (33, 'Redes de Computadores'), (34, 'Segurança da Informação'), (35, 'Governança de TI'),
(36, 'Programação Java'), (37, 'Programação Python'), (38, 'Estrutura de Dados'), (39, 'Sistemas Operacionais'), (40, 'Inteligência Artificial'),
(41, 'Física'), (42, 'Química'), (43, 'Biologia'), (44, 'História do Brasil'), (45, 'Geografia'),
(46, 'Atualidades'), (47, 'Legislação de Trânsito'), (48, 'Medicina Legal'), (49, 'Criminologia'), (50, 'Redação Oficial');

-- Tabela: bancaModel
INSERT INTO banca (id, razao_social, sigla, cnpj, email, telefone, ativo) VALUES
(1, 'Centro Brasileiro de Pesquisa em Avaliação', 'CEBRASPE', '00000000000101', 'contato@cebraspe.org.br', '6134480100', 1),
(2, 'Fundação Getúlio Vargas', 'FGV', '00000000000102', 'concursos@fgv.br', '2137994600', 1),
(3, 'Fundação Carlos Chagas', 'FCC', '00000000000103', 'sac@fcc.org.br', '1137234388', 1),
(4, 'Fundação Vunesp', 'VUNESP', '00000000000104', 'vunesp@vunesp.com.br', '1138746300', 1),
(5, 'Instituto AOCP', 'AOCP', '00000000000105', 'candidato@aocp.com.br', '4433444242', 1),
(6, 'Instituto Brasileiro de Formação e Capacitação', 'IBFC', '00000000000106', 'concurso@ibfc.org.br', '1147881430', 1),
(7, 'Instituto Quadrix', 'QUADRIX', '00000000000107', 'contato@quadrix.org.br', '6135500000', 1),
(8, 'Fundação Cesgranrio', 'CESGRANRIO', '00000000000108', 'concursos@cesgranrio.org.br', '2121039600', 1),
(9, 'Instituto Consulplan', 'CONSULPLAN', '00000000000109', 'atendimento@consulplan.com', '3237294700', 1),
(10, 'Fundação de Apoio à Pesquisa', 'FAPEC', '00000000000110', 'fapec@fapec.org', '6733455900', 1),
(11, 'Banca Exemplo 11', 'BNC11', '00000000000111', 'contato11@banca.com', '1199999011', 1),
(12, 'Banca Exemplo 12', 'BNC12', '00000000000112', 'contato12@banca.com', '1199999012', 1),
(13, 'Banca Exemplo 13', 'BNC13', '00000000000113', 'contato13@banca.com', '1199999013', 1),
(14, 'Banca Exemplo 14', 'BNC14', '00000000000114', 'contato14@banca.com', '1199999014', 1),
(15, 'Banca Exemplo 15', 'BNC15', '00000000000115', 'contato15@banca.com', '1199999015', 1),
(16, 'Banca Exemplo 16', 'BNC16', '00000000000116', 'contato16@banca.com', '1199999016', 1),
(17, 'Banca Exemplo 17', 'BNC17', '00000000000117', 'contato17@banca.com', '1199999017', 1),
(18, 'Banca Exemplo 18', 'BNC18', '00000000000118', 'contato18@banca.com', '1199999018', 1),
(19, 'Banca Exemplo 19', 'BNC19', '00000000000119', 'contato19@banca.com', '1199999019', 1),
(20, 'Banca Exemplo 20', 'BNC20', '00000000000120', 'contato20@banca.com', '1199999020', 1),
(21, 'Banca Exemplo 21', 'BNC21', '00000000000121', 'contato21@banca.com', '1199999021', 1),
(22, 'Banca Exemplo 22', 'BNC22', '00000000000122', 'contato22@banca.com', '1199999022', 1),
(23, 'Banca Exemplo 23', 'BNC23', '00000000000123', 'contato23@banca.com', '1199999023', 1),
(24, 'Banca Exemplo 24', 'BNC24', '00000000000124', 'contato24@banca.com', '1199999024', 1),
(25, 'Banca Exemplo 25', 'BNC25', '00000000000125', 'contato25@banca.com', '1199999025', 1),
(26, 'Banca Exemplo 26', 'BNC26', '00000000000126', 'contato26@banca.com', '1199999026', 1),
(27, 'Banca Exemplo 27', 'BNC27', '00000000000127', 'contato27@banca.com', '1199999027', 1),
(28, 'Banca Exemplo 28', 'BNC28', '00000000000128', 'contato28@banca.com', '1199999028', 1),
(29, 'Banca Exemplo 29', 'BNC29', '00000000000129', 'contato29@banca.com', '1199999029', 1),
(30, 'Banca Exemplo 30', 'BNC30', '00000000000130', 'contato30@banca.com', '1199999030', 1),
(31, 'Banca Exemplo 31', 'BNC31', '00000000000131', 'contato31@banca.com', '1199999031', 1),
(32, 'Banca Exemplo 32', 'BNC32', '00000000000132', 'contato32@banca.com', '1199999032', 1),
(33, 'Banca Exemplo 33', 'BNC33', '00000000000133', 'contato33@banca.com', '1199999033', 1),
(34, 'Banca Exemplo 34', 'BNC34', '00000000000134', 'contato34@banca.com', '1199999034', 1),
(35, 'Banca Exemplo 35', 'BNC35', '00000000000135', 'contato35@banca.com', '1199999035', 1),
(36, 'Banca Exemplo 36', 'BNC36', '00000000000136', 'contato36@banca.com', '1199999036', 1),
(37, 'Banca Exemplo 37', 'BNC37', '00000000000137', 'contato37@banca.com', '1199999037', 1),
(38, 'Banca Exemplo 38', 'BNC38', '00000000000138', 'contato38@banca.com', '1199999038', 1),
(39, 'Banca Exemplo 39', 'BNC39', '00000000000139', 'contato39@banca.com', '1199999039', 1),
(40, 'Banca Exemplo 40', 'BNC40', '00000000000140', 'contato40@banca.com', '1199999040', 1),
(41, 'Banca Exemplo 41', 'BNC41', '00000000000141', 'contato41@banca.com', '1199999041', 1),
(42, 'Banca Exemplo 42', 'BNC42', '00000000000142', 'contato42@banca.com', '1199999042', 1),
(43, 'Banca Exemplo 43', 'BNC43', '00000000000143', 'contato43@banca.com', '1199999043', 1),
(44, 'Banca Exemplo 44', 'BNC44', '00000000000144', 'contato44@banca.com', '1199999044', 1),
(45, 'Banca Exemplo 45', 'BNC45', '00000000000145', 'contato45@banca.com', '1199999045', 1),
(46, 'Banca Exemplo 46', 'BNC46', '00000000000146', 'contato46@banca.com', '1199999046', 1),
(47, 'Banca Exemplo 47', 'BNC47', '00000000000147', 'contato47@banca.com', '1199999047', 1),
(48, 'Banca Exemplo 48', 'BNC48', '00000000000148', 'contato48@banca.com', '1199999048', 1),
(49, 'Banca Exemplo 49', 'BNC49', '00000000000149', 'contato49@banca.com', '1199999049', 1),
(50, 'Banca Exemplo 50', 'BNC50', '00000000000150', 'contato50@banca.com', '1199999050', 1);

-- Tabela: instituicaoModel
INSERT INTO instituicao (id, razao_social, sigla, cnpj, email, telefone, ativo) VALUES
(1, 'Polícia Federal', 'PF', '00000000000201', 'rh@pf.gov.br', '6120248000', 1),
(2, 'Receita Federal', 'RFB', '00000000000202', 'contato@rfb.gov.br', '6134122000', 1),
(3, 'Tribunal de Contas da União', 'TCU', '00000000000203', 'rh@tcu.gov.br', '6133167000', 1),
(4, 'Banco Central do Brasil', 'BACEN', '00000000000204', 'rh@bcb.gov.br', '6134141414', 1),
(5, 'Caixa Econômica Federal', 'CEF', '00000000000205', 'rh@caixa.gov.br', '6130000000', 1),
(6, 'Prefeitura Municipal A', 'PMA', '00000000000206', 'rh@pma.gov.br', '1130000006', 1),
(7, 'Prefeitura Municipal B', 'PMB', '00000000000207', 'rh@pmb.gov.br', '1130000007', 1),
(8, 'Tribunal de Justiça SP', 'TJSP', '00000000000208', 'rh@tjsp.jus.br', '1130000008', 1),
(9, 'Tribunal Regional Eleitoral', 'TRE', '00000000000209', 'rh@tre.jus.br', '1130000009', 1),
(10, 'Ministério Público', 'MP', '00000000000210', 'rh@mp.mp.br', '1130000010', 1),
(11, 'Inst. Exemplo 11', 'INST11', '00000000000211', 'email11@inst.com', '1130000011', 1),
(12, 'Inst. Exemplo 12', 'INST12', '00000000000212', 'email12@inst.com', '1130000012', 1),
(13, 'Inst. Exemplo 13', 'INST13', '00000000000213', 'email13@inst.com', '1130000013', 1),
(14, 'Inst. Exemplo 14', 'INST14', '00000000000214', 'email14@inst.com', '1130000014', 1),
(15, 'Inst. Exemplo 15', 'INST15', '00000000000215', 'email15@inst.com', '1130000015', 1),
(16, 'Inst. Exemplo 16', 'INST16', '00000000000216', 'email16@inst.com', '1130000016', 1),
(17, 'Inst. Exemplo 17', 'INST17', '00000000000217', 'email17@inst.com', '1130000017', 1),
(18, 'Inst. Exemplo 18', 'INST18', '00000000000218', 'email18@inst.com', '1130000018', 1),
(19, 'Inst. Exemplo 19', 'INST19', '00000000000219', 'email19@inst.com', '1130000019', 1),
(20, 'Inst. Exemplo 20', 'INST20', '00000000000220', 'email20@inst.com', '1130000020', 1),
(21, 'Inst. Exemplo 21', 'INST21', '00000000000221', 'email21@inst.com', '1130000021', 1),
(22, 'Inst. Exemplo 22', 'INST22', '00000000000222', 'email22@inst.com', '1130000022', 1),
(23, 'Inst. Exemplo 23', 'INST23', '00000000000223', 'email23@inst.com', '1130000023', 1),
(24, 'Inst. Exemplo 24', 'INST24', '00000000000224', 'email24@inst.com', '1130000024', 1),
(25, 'Inst. Exemplo 25', 'INST25', '00000000000225', 'email25@inst.com', '1130000025', 1),
(26, 'Inst. Exemplo 26', 'INST26', '00000000000226', 'email26@inst.com', '1130000026', 1),
(27, 'Inst. Exemplo 27', 'INST27', '00000000000227', 'email27@inst.com', '1130000027', 1),
(28, 'Inst. Exemplo 28', 'INST28', '00000000000228', 'email28@inst.com', '1130000028', 1),
(29, 'Inst. Exemplo 29', 'INST29', '00000000000229', 'email29@inst.com', '1130000029', 1),
(30, 'Inst. Exemplo 30', 'INST30', '00000000000230', 'email30@inst.com', '1130000030', 1),
(31, 'Inst. Exemplo 31', 'INST31', '00000000000231', 'email31@inst.com', '1130000031', 1),
(32, 'Inst. Exemplo 32', 'INST32', '00000000000232', 'email32@inst.com', '1130000032', 1),
(33, 'Inst. Exemplo 33', 'INST33', '00000000000233', 'email33@inst.com', '1130000033', 1),
(34, 'Inst. Exemplo 34', 'INST34', '00000000000234', 'email34@inst.com', '1130000034', 1),
(35, 'Inst. Exemplo 35', 'INST35', '00000000000235', 'email35@inst.com', '1130000035', 1),
(36, 'Inst. Exemplo 36', 'INST36', '00000000000236', 'email36@inst.com', '1130000036', 1),
(37, 'Inst. Exemplo 37', 'INST37', '00000000000237', 'email37@inst.com', '1130000037', 1),
(38, 'Inst. Exemplo 38', 'INST38', '00000000000238', 'email38@inst.com', '1130000038', 1),
(39, 'Inst. Exemplo 39', 'INST39', '00000000000239', 'email39@inst.com', '1130000039', 1),
(40, 'Inst. Exemplo 40', 'INST40', '00000000000240', 'email40@inst.com', '1130000040', 1),
(41, 'Inst. Exemplo 41', 'INST41', '00000000000241', 'email41@inst.com', '1130000041', 1),
(42, 'Inst. Exemplo 42', 'INST42', '00000000000242', 'email42@inst.com', '1130000042', 1),
(43, 'Inst. Exemplo 43', 'INST43', '00000000000243', 'email43@inst.com', '1130000043', 1),
(44, 'Inst. Exemplo 44', 'INST44', '00000000000244', 'email44@inst.com', '1130000044', 1),
(45, 'Inst. Exemplo 45', 'INST45', '00000000000245', 'email45@inst.com', '1130000045', 1),
(46, 'Inst. Exemplo 46', 'INST46', '00000000000246', 'email46@inst.com', '1130000046', 1),
(47, 'Inst. Exemplo 47', 'INST47', '00000000000247', 'email47@inst.com', '1130000047', 1),
(48, 'Inst. Exemplo 48', 'INST48', '00000000000248', 'email48@inst.com', '1130000048', 1),
(49, 'Inst. Exemplo 49', 'INST49', '00000000000249', 'email49@inst.com', '1130000049', 1),
(50, 'Inst. Exemplo 50', 'INST50', '00000000000250', 'email50@inst.com', '1130000050', 1);

-- Tabela: cargoModel
INSERT INTO cargo (id, nome, nivel_escolaridade) VALUES
(1, 'Agente Administrativo', 'Médio'), (2, 'Analista Judiciário', 'Superior'), (3, 'Técnico Judiciário', 'Médio'), (4, 'Auditor Fiscal', 'Superior'), (5, 'Delegado', 'Superior'),
(6, 'Escrivão', 'Superior'), (7, 'Perito Criminal', 'Superior'), (8, 'Professor', 'Superior'), (9, 'Médico', 'Superior'), (10, 'Enfermeiro', 'Superior'),
(11, 'Técnico de Enfermagem', 'Médio'), (12, 'Analista de Sistemas', 'Superior'), (13, 'Técnico em TI', 'Médio'), (14, 'Engenheiro Civil', 'Superior'), (15, 'Arquiteto', 'Superior'),
(16, 'Assistente Social', 'Superior'), (17, 'Psicólogo', 'Superior'), (18, 'Contador', 'Superior'), (19, 'Economista', 'Superior'), (20, 'Administrador', 'Superior'),
(21, 'Motorista', 'Fundamental'), (22, 'Auxiliar de Serviços Gerais', 'Fundamental'), (23, 'Merendeira', 'Fundamental'), (24, 'Vigia', 'Fundamental'), (25, 'Guarda Municipal', 'Médio'),
(26, 'Policial Militar', 'Médio'), (27, 'Bombeiro Militar', 'Médio'), (28, 'Agente de Trânsito', 'Médio'), (29, 'Fiscal de Posturas', 'Médio'), (30, 'Procurador', 'Superior'),
(31, 'Defensor Público', 'Superior'), (32, 'Juiz Substituto', 'Superior'), (33, 'Promotor de Justiça', 'Superior'), (34, 'Diplomata', 'Superior'), (35, 'Oficial de Chancelaria', 'Superior'),
(36, 'Analista Legislativo', 'Superior'), (37, 'Técnico Legislativo', 'Médio'), (38, 'Consultor Legislativo', 'Superior'), (39, 'Gestor Público', 'Superior'), (40, 'Analista de Comércio Exterior', 'Superior'),
(41, 'Papiloscopista', 'Superior'), (42, 'Agente Penitenciário', 'Médio'), (43, 'Bibliotecário', 'Superior'), (44, 'Arquivista', 'Superior'), (45, 'Jornalista', 'Superior'),
(46, 'Relações Públicas', 'Superior'), (47, 'Nutricionista', 'Superior'), (48, 'Fisioterapeuta', 'Superior'), (49, 'Farmacêutico', 'Superior'), (50, 'Biólogo', 'Superior');

-- Tabela: usuarioModel
INSERT INTO usuario (id, nome, email, data_nascimento, sexo, senha, perfil, cpf, celular, telefone, ativo) VALUES
(1, 'João Silva', 'joao.silva@teste.com', '1990-01-01', 'M', '123456', 'ADMIN', '11111111101', '11999990001', NULL, 1),
(2, 'Maria Oliveira', 'maria.oliveira@teste.com', '1992-05-15', 'F', '123456', 'PROFESSOR', '11111111102', '11999990002', NULL, 1),
(3, 'Pedro Santos', 'pedro.santos@teste.com', '1985-08-20', 'M', '123456', 'ALUNO', '11111111103', '11999990003', NULL, 1),
(4, 'Ana Costa', 'ana.costa@teste.com', '1995-12-10', 'F', '123456', 'ALUNO', '11111111104', '11999990004', NULL, 1),
(5, 'Carlos Pereira', 'carlos.pereira@teste.com', '1988-03-25', 'M', '123456', 'PROFESSOR', '11111111105', '11999990005', NULL, 1),
(6, 'Usuario 6', 'user6@teste.com', '1990-01-06', 'M', 'pass', 'ALUNO', '11111111106', '11999990006', NULL, 1),
(7, 'Usuario 7', 'user7@teste.com', '1990-01-07', 'F', 'pass', 'ALUNO', '11111111107', '11999990007', NULL, 1),
(8, 'Usuario 8', 'user8@teste.com', '1990-01-08', 'M', 'pass', 'ALUNO', '11111111108', '11999990008', NULL, 1),
(9, 'Usuario 9', 'user9@teste.com', '1990-01-09', 'F', 'pass', 'ALUNO', '11111111109', '11999990009', NULL, 1),
(10, 'Usuario 10', 'user10@teste.com', '1990-01-10', 'M', 'pass', 'ALUNO', '11111111110', '11999990010', NULL, 1),
(11, 'Usuario 11', 'user11@teste.com', '1990-01-11', 'F', 'pass', 'ALUNO', '11111111111', '11999990011', NULL, 1),
(12, 'Usuario 12', 'user12@teste.com', '1990-01-12', 'M', 'pass', 'ALUNO', '11111111112', '11999990012', NULL, 1),
(13, 'Usuario 13', 'user13@teste.com', '1990-01-13', 'F', 'pass', 'ALUNO', '11111111113', '11999990013', NULL, 1),
(14, 'Usuario 14', 'user14@teste.com', '1990-01-14', 'M', 'pass', 'ALUNO', '11111111114', '11999990014', NULL, 1),
(15, 'Usuario 15', 'user15@teste.com', '1990-01-15', 'F', 'pass', 'ALUNO', '11111111115', '11999990015', NULL, 1),
(16, 'Usuario 16', 'user16@teste.com', '1990-01-16', 'M', 'pass', 'ALUNO', '11111111116', '11999990016', NULL, 1),
(17, 'Usuario 17', 'user17@teste.com', '1990-01-17', 'F', 'pass', 'ALUNO', '11111111117', '11999990017', NULL, 1),
(18, 'Usuario 18', 'user18@teste.com', '1990-01-18', 'M', 'pass', 'ALUNO', '11111111118', '11999990018', NULL, 1),
(19, 'Usuario 19', 'user19@teste.com', '1990-01-19', 'F', 'pass', 'ALUNO', '11111111119', '11999990019', NULL, 1),
(20, 'Usuario 20', 'user20@teste.com', '1990-01-20', 'M', 'pass', 'ALUNO', '11111111120', '11999990020', NULL, 1),
(21, 'Usuario 21', 'user21@teste.com', '1990-01-21', 'F', 'pass', 'ALUNO', '11111111121', '11999990021', NULL, 1),
(22, 'Usuario 22', 'user22@teste.com', '1990-01-22', 'M', 'pass', 'ALUNO', '11111111122', '11999990022', NULL, 0),
(23, 'Usuario 23', 'user23@teste.com', '1990-01-23', 'F', 'pass', 'ALUNO', '11111111123', '11999990023', NULL, 0),
(24, 'Usuario 24', 'user24@teste.com', '1990-01-24', 'M', 'pass', 'ALUNO', '11111111124', '11999990024', NULL, 0),
(25, 'Usuario 25', 'user25@teste.com', '1990-01-25', 'F', 'pass', 'ALUNO', '11111111125', '11999990025', NULL, 0),
(26, 'Usuario 26', 'user26@teste.com', '1990-01-26', 'M', 'pass', 'ALUNO', '11111111126', '11999990026', NULL, 0),
(27, 'Usuario 27', 'user27@teste.com', '1990-01-27', 'F', 'pass', 'ALUNO', '11111111127', '11999990027', NULL, 0),
(28, 'Usuario 28', 'user28@teste.com', '1990-01-28', 'M', 'pass', 'ALUNO', '11111111128', '11999990028', NULL, 0),
(29, 'Usuario 29', 'user29@teste.com', '1990-01-29', 'F', 'pass', 'ALUNO', '11111111129', '11999990029', NULL, 0),
(30, 'Usuario 30', 'user30@teste.com', '1990-01-30', 'M', 'pass', 'ALUNO', '11111111130', '11999990030', NULL, 1),
(31, 'Usuario 31', 'user31@teste.com', '1990-01-31', 'F', 'pass', 'ALUNO', '11111111131', '11999990031', NULL, 1),
(32, 'Usuario 32', 'user32@teste.com', '1990-02-01', 'M', 'pass', 'ALUNO', '11111111132', '11999990032', NULL, 1),
(33, 'Usuario 33', 'user33@teste.com', '1990-02-02', 'F', 'pass', 'ALUNO', '11111111133', '11999990033', NULL, 1),
(34, 'Usuario 34', 'user34@teste.com', '1990-02-03', 'M', 'pass', 'ALUNO', '11111111134', '11999990034', NULL, 1),
(35, 'Usuario 35', 'user35@teste.com', '1990-02-04', 'F', 'pass', 'ALUNO', '11111111135', '11999990035', NULL, 1),
(36, 'Usuario 36', 'user36@teste.com', '1990-02-05', 'M', 'pass', 'ALUNO', '11111111136', '11999990036', NULL, 1),
(37, 'Usuario 37', 'user37@teste.com', '1990-02-06', 'F', 'pass', 'ALUNO', '11111111137', '11999990037', NULL, 1),
(38, 'Usuario 38', 'user38@teste.com', '1990-02-07', 'M', 'pass', 'ALUNO', '11111111138', '11999990038', NULL, 1),
(39, 'Usuario 39', 'user39@teste.com', '1990-02-08', 'F', 'pass', 'ALUNO', '11111111139', '11999990039', NULL, 1),
(40, 'Usuario 40', 'user40@teste.com', '1990-02-09', 'M', 'pass', 'ALUNO', '11111111140', '11999990040', NULL, 1),
(41, 'Usuario 41', 'user41@teste.com', '1990-02-10', 'F', 'pass', 'ALUNO', '11111111141', '11999990041', NULL, 1),
(42, 'Usuario 42', 'user42@teste.com', '1990-02-11', 'M', 'pass', 'ALUNO', '11111111142', '11999990042', NULL, 1),
(43, 'Usuario 43', 'user43@teste.com', '1990-02-12', 'F', 'pass', 'ALUNO', '11111111143', '11999990043', NULL, 1),
(44, 'Usuario 44', 'user44@teste.com', '1990-02-13', 'M', 'pass', 'ALUNO', '11111111144', '11999990044', NULL, 1),
(45, 'Usuario 45', 'user45@teste.com', '1990-02-14', 'F', 'pass', 'ALUNO', '11111111145', '11999990045', NULL, 1),
(46, 'Usuario 46', 'user46@teste.com', '1990-02-15', 'M', 'pass', 'ALUNO', '11111111146', '11999990046', NULL, 1),
(47, 'Usuario 47', 'user47@teste.com', '1990-02-16', 'F', 'pass', 'ALUNO', '11111111147', '11999990047', NULL, 1),
(48, 'Usuario 48', 'user48@teste.com', '1990-02-17', 'M', 'pass', 'ALUNO', '11111111148', '11999990048', NULL, 1),
(49, 'Usuario 49', 'user49@teste.com', '1990-02-18', 'F', 'pass', 'ALUNO', '11111111149', '11999990049', NULL, 1),
(50, 'Usuario 50', 'user50@teste.com', '1990-02-19', 'M', 'pass', 'ALUNO', '11111111150', '11999990050', NULL, 1);

-- =================================================================================
-- 2. TABELAS DE DEPENDÊNCIA NÍVEL 1
-- =================================================================================

-- Tabela: assunto
INSERT INTO assunto (id, nome, id_disciplina) VALUES
(1, 'Crase', 1), (2, 'Porcentagem', 2), (3, 'Tautologia', 3), (4, 'Direitos Fundamentais', 4), (5, 'Atos Administrativos', 5),
(6, 'Excel', 6), (7, 'Verb Tenses', 7), (8, 'PDCA', 8), (9, 'Gestão de Documentos', 9), (10, 'Balanço Patrimonial', 10),
(11, 'Microeconomia', 11), (12, 'Média e Mediana', 12), (13, 'Crimes contra a Vida', 13), (14, 'Inquérito Policial', 14), (15, 'Personalidade Jurídica', 15),
(16, 'Recursos', 16), (17, 'Impostos', 17), (18, 'Tipos de Sociedade', 18), (19, 'CLT', 19), (20, 'Audiências', 20),
(21, 'Seguridade Social', 21), (22, 'Partidos Políticos', 22), (23, 'Licenciamento Ambiental', 23), (24, 'CDC', 24), (25, 'Declaração Universal', 25),
(26, 'Código de Ética', 26), (27, 'Teorias da Administração', 27), (28, 'Orçamento Público', 28), (29, 'Lei 4320', 29), (30, 'Auditoria Interna', 30),
(31, 'SQL', 31), (32, 'Scrum', 32), (33, 'TCP/IP', 33), (34, 'Criptografia', 34), (35, 'COBIT', 35),
(36, 'Polimorfismo', 36), (37, 'List Comprehension', 37), (38, 'Árvores Binárias', 38), (39, 'Linux', 39), (40, 'Machine Learning', 40),
(41, 'Cinemática', 41), (42, 'Tabela Periódica', 42), (43, 'Genética', 43), (44, 'Era Vargas', 44), (45, 'Geopolítica', 45),
(46, 'Política Internacional', 46), (47, 'CTB', 47), (48, 'Traumatologia Forense', 48), (49, 'Vitimologia', 49), (50, 'Pronomes de Tratamento', 50);

-- Tabela: concurso
INSERT INTO concurso (id, nome, ano, cancelado, ativo, id_banca, id_instituicao) VALUES
(1, 'Concurso PF 2024', '2024-01-01', 0, 1, 1, 1),
(2, 'Concurso Receita 2024', '2024-01-01', 0, 1, 2, 2),
(3, 'Concurso TCU 2023', '2023-05-01', 0, 0, 3, 3),
(4, 'Concurso BACEN 2025', '2025-02-01', 0, 1, 1, 4),
(5, 'Concurso Caixa 2024', '2024-03-01', 0, 1, 4, 5),
(6, 'Concurso Pref A', '2024-01-01', 0, 1, 6, 6),
(7, 'Concurso Pref B', '2024-01-01', 0, 1, 7, 7),
(8, 'Concurso TJSP', '2024-01-01', 0, 1, 8, 8),
(9, 'Concurso TRE', '2024-01-01', 0, 1, 9, 9),
(10, 'Concurso MP', '2024-01-01', 0, 1, 10, 10),
(11, 'Concurso Genérico 11', '2023-01-01', 0, 1, 11, 11), (12, 'Concurso Genérico 12', '2024-01-01', 0, 1, 12, 12),
(13, 'Concurso Genérico 13', '2024-01-01', 0, 1, 13, 13), (14, 'Concurso Genérico 14', '2024-01-01', 1, 1, 14, 14),
(15, 'Concurso Genérico 15', '2025-01-01', 0, 1, 15, 15), (16, 'Concurso Genérico 16', '2024-01-01', 1, 1, 16, 16),
(17, 'Concurso Genérico 17', '2023-01-01', 0, 1, 17, 17), (18, 'Concurso Genérico 18', '2024-01-01', 1, 1, 18, 18),
(19, 'Concurso Genérico 19', '2024-01-01', 0, 1, 19, 19), (20, 'Concurso Genérico 20', '2024-01-01', 1, 1, 20, 20),
(21, 'Concurso Genérico 21', '2025-01-01', 0, 1, 21, 21), (22, 'Concurso Genérico 22', '2024-01-01', 1, 1, 22, 22),
(23, 'Concurso Genérico 23', '2024-01-01', 0, 1, 23, 23), (24, 'Concurso Genérico 24', '2024-01-01', 1, 1, 24, 24),
(25, 'Concurso Genérico 25', '2023-01-01', 0, 1, 25, 25), (26, 'Concurso Genérico 26', '2024-01-01', 0, 1, 26, 26),
(27, 'Concurso Genérico 27', '2024-01-01', 0, 1, 27, 27), (28, 'Concurso Genérico 28', '2024-01-01', 0, 1, 28, 28),
(29, 'Concurso Genérico 29', '2025-01-01', 0, 1, 29, 29), (30, 'Concurso Genérico 30', '2024-01-01', 0, 1, 30, 30),
(31, 'Concurso Genérico 31', '2024-01-01', 0, 1, 31, 31), (32, 'Concurso Genérico 32', '2024-01-01', 0, 0, 32, 32),
(33, 'Concurso Genérico 33', '2023-01-01', 0, 1, 33, 33), (34, 'Concurso Genérico 34', '2024-01-01', 0, 0, 34, 34),
(35, 'Concurso Genérico 35', '2022-01-01', 0, 1, 35, 35), (36, 'Concurso Genérico 36', '2024-01-01', 0, 0, 36, 36),
(37, 'Concurso Genérico 37', '2021-01-01', 0, 1, 37, 37), (38, 'Concurso Genérico 38', '2024-01-01', 0, 1, 38, 38),
(39, 'Concurso Genérico 39', '2021-01-01', 0, 1, 39, 39), (40, 'Concurso Genérico 40', '2024-01-01', 0, 1, 40, 40),
(41, 'Concurso Genérico 41', '2022-01-01', 0, 1, 41, 41), (42, 'Concurso Genérico 42', '2024-01-01', 0, 1, 42, 42),
(43, 'Concurso Genérico 43', '2020-01-01', 0, 1, 43, 43), (44, 'Concurso Genérico 44', '2024-01-01', 0, 0, 44, 44),
(45, 'Concurso Genérico 45', '2019-01-01', 0, 1, 45, 45), (46, 'Concurso Genérico 46', '2024-01-01', 0, 0, 46, 46),
(47, 'Concurso Genérico 47', '2024-01-01', 0, 1, 47, 47), (48, 'Concurso Genérico 48', '2024-01-01', 0, 0, 48, 48),
(49, 'Concurso Genérico 49', '2024-01-01', 0, 1, 49, 49), (50, 'Concurso Genérico 50', '2024-01-01', 0, 0, 50, 50);

-- =================================================================================
-- 3. TABELAS DE DEPENDÊNCIA NÍVEL 2 E 3 (Prova e Questão)
-- =================================================================================

-- Tabela: prova
INSERT INTO prova (id, nome, data_aplicacao, id_concurso, id_cargo) VALUES
(1, 'Prova Objetiva PF Agente', '2024-02-01', 1, 1),
(2, 'Prova Objetiva Receita Auditor', '2024-02-01', 2, 4),
(3, 'Prova Objetiva TCU Auditor', '2023-06-01', 3, 4),
(4, 'Prova Objetiva Bacen TI', '2025-03-01', 4, 12),
(5, 'Prova Objetiva Caixa Téc', '2024-04-01', 5, 3),
(6, 'Prova 6', '2024-01-01', 6, 6), (7, 'Prova 7', '2024-01-01', 7, 7), (8, 'Prova 8', '2024-01-01', 8, 8),
(9, 'Prova 9', '2024-01-01', 9, 9), (10, 'Prova 10', '2024-01-01', 10, 10), (11, 'Prova 11', '2024-01-01', 11, 11),
(12, 'Prova 12', '2024-01-01', 12, 12), (13, 'Prova 13', '2024-01-01', 13, 13), (14, 'Prova 14', '2024-01-01', 14, 14),
(15, 'Prova 15', '2024-01-01', 15, 15), (16, 'Prova 16', '2024-01-01', 16, 16), (17, 'Prova 17', '2024-01-01', 17, 17),
(18, 'Prova 18', '2024-01-01', 18, 18), (19, 'Prova 19', '2024-01-01', 19, 19), (20, 'Prova 20', '2024-01-01', 20, 20),
(21, 'Prova 21', '2024-01-01', 21, 21), (22, 'Prova 22', '2024-01-01', 22, 22), (23, 'Prova 23', '2024-01-01', 23, 23),
(24, 'Prova 24', '2024-01-01', 24, 24), (25, 'Prova 25', '2024-01-01', 25, 25), (26, 'Prova 26', '2024-01-01', 26, 26),
(27, 'Prova 27', '2024-01-01', 27, 27), (28, 'Prova 28', '2024-01-01', 28, 28), (29, 'Prova 29', '2024-01-01', 29, 29),
(30, 'Prova 30', '2024-01-01', 30, 30), (31, 'Prova 31', '2024-01-01', 31, 31), (32, 'Prova 32', '2024-01-01', 32, 32),
(33, 'Prova 33', '2024-01-01', 33, 33), (34, 'Prova 34', '2024-01-01', 34, 34), (35, 'Prova 35', '2024-01-01', 35, 35),
(36, 'Prova 36', '2024-01-01', 36, 36), (37, 'Prova 37', '2024-01-01', 37, 37), (38, 'Prova 38', '2024-01-01', 38, 38),
(39, 'Prova 39', '2024-01-01', 39, 39), (40, 'Prova 40', '2024-01-01', 40, 40), (41, 'Prova 41', '2024-01-01', 41, 41),
(42, 'Prova 42', '2024-01-01', 42, 42), (43, 'Prova 43', '2024-01-01', 43, 43), (44, 'Prova 44', '2024-01-01', 44, 44),
(45, 'Prova 45', '2024-01-01', 45, 45), (46, 'Prova 46', '2024-01-01', 46, 46), (47, 'Prova 47', '2024-01-01', 47, 47),
(48, 'Prova 48', '2024-01-01', 48, 48), (49, 'Prova 49', '2024-01-01', 49, 49), (50, 'Prova 50', '2024-01-01', 50, 50);

-- Tabela: questao
INSERT INTO questao (id, enunciado, comentario_professor, anulada, id_prova, id_assunto, data_anulacao, data_criacao) VALUES
(1, 'Questão 1 sobre Crase', 'Comentário sobre Crase - Anulada por erro material.', 1, 1, 1, '2024-05-25', '2026-02-05'),
(2, 'Questão 2 sobre Porcentagem', 'Comentário sobre Porcentagem - Gabarito divergente.', 1, 2, 2, '2024-05-22', '2026-02-05'),
(3, 'Questão 3 sobre Tautologia', NULL, 0, 3, 3, NULL, '2026-02-05'),
(4, 'Questão 4 sobre Direitos Fundamentais', 'Ver art 5 da CF', 0, 4, 4, NULL, '2026-02-05'),
(5, 'Questão 5 sobre Atos Administrativos', 'Ato discricionário', 0, 5, 5, NULL, '2026-02-05'),
(6, 'Questão Genérica 6', 'Comentário 6', 0, 6, 6, NULL, '2026-02-05'),
(7, 'Questão Genérica 7', 'Comentário 7', 0, 7, 7, NULL, '2026-02-05'),
(8, 'Questão Genérica 8', 'Comentário 8', 0, 8, 8, NULL, '2026-02-05'),
(9, 'Questão Genérica 9', 'Comentário 9', 0, 9, 9, NULL, '2026-02-05'),
(10, 'Questão Genérica 10', 'Comentário 10', 0, 10, 10, NULL, '2026-02-05'),
(11, 'Questão Genérica 11', NULL, 0, 11, 11, NULL, '2026-02-05'),
(12, 'Questão Genérica 12', NULL, 0, 12, 12, NULL, '2026-02-05'),
(13, 'Questão Genérica 13', NULL, 0, 13, 13, NULL, '2026-02-05'),
(14, 'Questão Genérica 14', NULL, 0, 14, 14, NULL, '2026-02-05'),
(15, 'Questão Genérica 15', 'Anulada: Duas assertivas corretas.', 1, 15, 15, '2024-05-21', '2026-02-05'),
(16, 'Questão Genérica 16', NULL, 0, 16, 16, NULL, '2026-02-05'),
(17, 'Questão Genérica 17', 'Anulada: Conteúdo não previsto no edital.', 1, 17, 17, '2024-05-15', '2026-02-05'),
(18, 'Questão Genérica 18', NULL, 0, 18, 18, NULL, '2026-02-05'),
(19, 'Questão Genérica 19', 'Anulada: Erro de digitação prejudicou a interpretação.', 1, 19, 19, '2024-05-20', '2026-02-05'),
(20, 'Questão Genérica 20', NULL, 0, 20, 20, NULL, '2026-02-05'),
(21, 'Questão Genérica 21', 'Anulada: Nenhuma das alternativas está correta.', 1, 21, 21, '2024-04-20', '2026-02-05'),
(22, 'Questão Genérica 22', NULL, 0, 22, 22, NULL, '2026-02-05'),
(23, 'Questão Genérica 23', 'Anulada: Divergência doutrinária sobre o tema.', 1, 23, 23, '2024-06-20', '2026-02-05'),
(24, 'Questão Genérica 24', NULL, 0, 24, 24, NULL, '2026-02-05'),
(25, 'Questão Genérica 25', 'Anulada: Questão repetida de prova anterior.', 1, 25, 25, '2024-07-20', '2026-02-05'),
(26, 'Questão Genérica 26', NULL, 0, 26, 26, NULL, '2026-02-05'),
(27, 'Questão Genérica 27', 'Anulada: Falta de clareza no enunciado.', 1, 27, 27, '2024-08-20', NULL),
(28, 'Questão Genérica 28', NULL, 0, 28, 28, NULL, NULL),
(29, 'Questão Genérica 29', 'Anulada: Gabarito alterado e posteriormente anulada.', 1, 29, 29, '2024-05-12', NULL),
(30, 'Questão Genérica 30', NULL, 0, 30, 30, NULL, NULL),
(31, 'Questão Genérica 31', 'Anulada: Erro na formulação das alternativas.', 1, 31, 31, '2024-05-30', NULL),
(32, 'Questão Genérica 32', NULL, 0, 32, 32, NULL, NULL),
(33, 'Questão Genérica 33', 'Anulada: Imagem de apoio ilegível.', 1, 33, 33, '2024-05-20', NULL),
(34, 'Questão Genérica 34', NULL, 0, 34, 34, NULL, NULL),
(35, 'Questão Genérica 35', 'Anulada: Dupla interpretação possível.', 1, 35, 35, '2024-05-12', NULL),
(36, 'Questão Genérica 36', NULL, 0, 36, 36, NULL, NULL),
(37, 'Questão Genérica 37', 'Anulada: Baseada em legislação revogada.', 1, 37, 37, '2024-05-13', NULL),
(38, 'Questão Genérica 38', NULL, 0, 38, 38, NULL, NULL),
(39, 'Questão Genérica 39', 'Anulada: Inconsistência nos dados apresentados.', 1, 39, 39, '2024-05-20', NULL),
(40, 'Questão Genérica 40', NULL, 0, 40, 40, NULL, NULL),
(41, 'Questão Genérica 41', 'Anulada: Questão incompleta.', 1, 41, 41, '2024-07-20', NULL),
(42, 'Questão Genérica 42', NULL, 0, 42, 42, NULL, NULL),
(43, 'Questão Genérica 43', 'Anulada: Fora do escopo bibliográfico.', 1, 43, 43, '2025-09-20', NULL),
(44, 'Questão Genérica 44', NULL, 0, 44, 44, NULL, NULL),
(45, 'Questão Genérica 45', 'Anulada: Erro de tradução no termo técnico.', 1, 45, 45, '2025-05-20', NULL),
(46, 'Questão Genérica 46', NULL, 0, 46, 46, NULL, NULL),
(47, 'Questão Genérica 47', 'Anulada: Múltiplas respostas corretas.', 1, 47, 47, '2024-05-20', NULL),
(48, 'Questão Genérica 48', NULL, 0, 48, 48, NULL, NULL),
(49, 'Questão Genérica 49', 'Anulada: Enunciado contraditório.', 1, 49, 49, '2024-05-20', NULL),
(50, 'Questão Genérica 50', NULL, 0, 50, 50, NULL, NULL),
(51, 'Com base nos estudos recentes, assinale a alternativa correta sobre o tema.', 'Verificar bibliografia básica.', 0, 1, 1, NULL, NULL),
(52, 'Analise as afirmativas a seguir e marque a opção que contém a sequência correta.', NULL, 0, 2, 2, NULL, NULL),
(53, 'No que tange à legislação vigente, é correto afirmar que:', 'Artigo 5º da constituição.', 0, 3, 3, '2025-11-20', NULL),
(54, 'Considere a situação hipotética descrita no texto associado.', NULL, 0, 4, 4, NULL, NULL),
(55, 'A respeito dos conceitos fundamentais, julgue os itens subsequentes.', 'Conceito clássico de administração.', 0, 5, 5, NULL, NULL),
(56, 'Qual das opções abaixo não representa uma violação das normas?', NULL, 0, 6, 6, NULL, NULL),
(57, 'Em relação aos processos de software, o modelo cascata se define por:', NULL, 0, 7, 7, NULL, NULL),
(58, 'O princípio da impessoalidade na administração pública impõe que:', 'Verificar princípios LIMPE.', 0, 8, 8, NULL, NULL),
(59, 'Assinale a alternativa que apresenta um exemplo de crime contra a honra.', NULL, 0, 9, 9, NULL, NULL),
(60, 'Sobre a concordância nominal, analise as frases abaixo.', 'Regra geral de adjetivos.', 1, 10, 10, '2025-11-20', NULL),
(61, 'O protocolo TCP/IP é fundamental para a internet porque:', NULL, 0, 11, 11, NULL, NULL),
(62, 'Na arquitetura de computadores, a CPU tem a função de:', NULL, 0, 12, 12, NULL, NULL),
(63, 'O fenômeno da crase ocorre obrigatoriamente quando:', 'Preposição A + Artigo A.', 0, 13, 13, NULL, NULL),
(64, 'Em um banco de dados relacional, a chave estrangeira serve para:', NULL, 0, 14, 14, NULL, NULL),
(65, 'Segundo a teoria de Maslow, as necessidades básicas são:', 'Pirâmide das necessidades.', 1, 15, 15, '2025-12-20', NULL),
(66, 'O Barroco no Brasil teve como principal representante:', NULL, 0, 16, 16, NULL, NULL),
(67, 'A fórmula de Bhaskara é utilizada para resolver equações de:', NULL, 0, 17, 17, NULL, NULL),
(68, 'No Excel, a função PROCV é utilizada para:', 'Busca vertical em colunas.', 0, 18, 18, NULL, NULL),
(69, 'Qual o atalho de teclado padrão para salvar arquivos no Windows?', NULL, 0, 19, 19, NULL, NULL),
(70, 'A Primeira Guerra Mundial teve como estopim:', NULL, 0, 20, 20, NULL, NULL),
(71, 'O relevo brasileiro é caracterizado predominantemente por:', 'Planaltos, planícies e depressões.', 1, 21, 21, '2025-12-20', NULL),
(72, 'A densidade demográfica é calculada através da razão entre:', NULL, 0, 22, 22, NULL, NULL),
(73, 'Em Java, a diferença entre uma classe abstrata e uma interface é:', NULL, 0, 23, 23, NULL, NULL),
(74, 'O Scrum é uma metodologia ágil que utiliza artefatos como:', 'Product Backlog e Sprint Backlog.', 0, 24, 24, NULL, NULL),
(75, 'A Lei de Responsabilidade Fiscal visa garantir:', NULL, 0, 25, 25, NULL, NULL),
(76, 'O Habeas Corpus é um remédio constitucional destinado a:', NULL, 0, 26, 26, NULL, NULL),
(77, 'Na análise combinatória, a permutação simples é dada por:', NULL, 0, 27, 27, NULL, NULL),
(78, 'O ciclo da água envolve processos físicos como:', 'Evaporação e condensação.', 0, 28, 28, NULL, NULL),
(79, 'A Revolução Industrial trouxe mudanças significativas como:', NULL, 0, 29, 29, NULL, NULL),
(80, 'O predicado verbo-nominal possui como núcleo:', NULL, 0, 30, 30, NULL, NULL),
(81, 'As orações subordinadas substantivas exercem função de:', 'Substantivo na oração principal.', 0, 31, 31, NULL, NULL),
(82, 'O movimento uniformemente variado (MUV) caracteriza-se por:', NULL, 0, 32, 32, NULL, NULL),
(83, 'A tabela periódica organiza os elementos de acordo com:', 'Número atômico.', 0, 33, 33, NULL, NULL),
(84, 'O citoplasma das células eucariontes contém:', NULL, 0, 34, 34, NULL, NULL),
(85, 'A Era Vargas foi marcada pela criação de:', NULL, 0, 35, 35, NULL, NULL),
(86, 'O Plano Real foi um plano econômico que visava:', 'Controlar a hiperinflação.', 0, 36, 36, NULL, NULL),
(87, 'A globalização tem como uma de suas características:', NULL, 0, 37, 37, NULL, NULL),
(88, 'O inquérito policial tem natureza jurídica de:', 'Procedimento administrativo.', 0, 38, 38, NULL, NULL),
(89, 'A legítima defesa é uma causa de:', 'Exclusão de ilicitude.', 0, 39, 39, NULL, NULL),
(90, 'O princípio da legalidade estrita aplica-se principalmente ao:', NULL, 0, 40, 40, NULL, NULL),
(91, 'A improbidade administrativa pode acarretar:', NULL, 0, 41, 41, NULL, NULL),
(92, 'Os poderes da administração pública incluem o poder:', 'Poder de Polícia.', 0, 42, 42, NULL, NULL),
(93, 'A licitação é dispensável nos casos de:', NULL, 0, 43, 43, NULL, NULL),
(94, 'O orçamento público no Brasil é regido pelo princípio da:', NULL, 0, 44, 44, NULL, NULL),
(95, 'A despesa pública pode ser classificada quanto à categoria em:', NULL, 0, 45, 45, NULL, NULL),
(96, 'O balanço patrimonial evidencia a situação:', 'Patrimonial e financeira.', 0, 46, 46, NULL, NULL),
(97, 'O ativo circulante compreende bens e direitos de:', 'Curto prazo.', 0, 47, 47, NULL, NULL),
(98, 'A auditoria governamental tem por finalidade:', NULL, 0, 48, 48, NULL, NULL),
(99, 'A segurança da informação baseia-se na tríade:', 'Confidencialidade, Integridade, Disponibilidade.', 0, 49, 49, NULL, NULL),
(100, 'O phishing é uma técnica de ataque que visa:', 'Enganar o usuário para obter dados.', 0, 50, 50, NULL, NULL),
(101, 'Questão avançada sobre o tópico abordado no texto II.', NULL, 0, 1, 1, NULL, NULL),
(102, 'Calcule o valor de X na equação logarítmica apresentada.', NULL, 0, 2, 2, NULL, NULL),
(103, 'Qual a negação lógica da proposição "Todo homem é mortal"?', 'Algum homem não é mortal.', 0, 3, 3, NULL, NULL),
(104, 'Os direitos sociais previstos na Constituição incluem:', NULL, 0, 4, 4, NULL, NULL),
(105, 'A anulação de um ato administrativo produz efeitos:', 'Ex tunc (retroativos).', 0, 5, 5, NULL, NULL),
(106, 'No Windows 10, o Gerenciador de Tarefas pode ser aberto por:', NULL, 0, 6, 6, NULL, NULL),
(107, 'O Simple Past tense é utilizado para descrever:', NULL, 0, 7, 7, NULL, NULL),
(108, 'A matriz SWOT analisa quais fatores?', 'Forças, Fraquezas, Oportunidades, Ameaças.', 0, 8, 8, NULL, NULL),
(109, 'A classificação dos arquivos quanto ao gênero pode ser:', NULL, 0, 9, 9, NULL, NULL),
(110, 'No método das partidas dobradas, cada débito corresponde a:', 'Um crédito de igual valor.', 0, 10, 10, NULL, NULL),
(111, 'A lei da oferta e da demanda determina que:', NULL, 0, 11, 11, NULL, NULL),
(112, 'A moda em um conjunto de dados estatísticos é:', 'O valor que mais se repete.', 0, 12, 12, NULL, NULL),
(113, 'O crime de homicídio é qualificado quando:', NULL, 0, 13, 13, NULL, NULL),
(114, 'A prisão em flagrante pode ser efetuada por:', 'Qualquer do povo (facultativo) e polícia (obrigatório).', 0, 14, 14, NULL, NULL),
(115, 'A capacidade civil plena é adquirida aos:', '18 anos.', 0, 15, 15, NULL, NULL),
(116, 'O recurso de apelação deve ser interposto no prazo de:', NULL, 0, 16, 16, NULL, NULL),
(117, 'O fato gerador do Imposto de Renda é:', NULL, 0, 17, 17, NULL, NULL),
(118, 'A sociedade limitada (LTDA) tem como característica:', NULL, 0, 18, 18, NULL, NULL),
(119, 'O aviso prévio proporcional ao tempo de serviço é de:', NULL, 0, 19, 19, NULL, NULL),
(120, 'O ônus da prova no processo do trabalho cabe:', 'A quem alega.', 0, 20, 20, NULL, NULL),
(121, 'O princípio da universalidade da cobertura e do atendimento refere-se à:', NULL, 0, 21, 21, NULL, NULL),
(122, 'O voto no Brasil é facultativo para:', 'Analfabetos e maiores de 70 anos.', 0, 22, 22, NULL, NULL),
(123, 'O Estudo de Impacto Ambiental (EIA) é exigido para:', NULL, 0, 23, 23, NULL, NULL),
(124, 'A inversão do ônus da prova no CDC é um direito:', 'Básico do consumidor.', 0, 24, 24, NULL, NULL),
(125, 'A dignidade da pessoa humana é um fundamento da:', 'República Federativa do Brasil.', 0, 25, 25, NULL, NULL),
(126, 'O servidor público deve agir com:', 'Ética, zelo e dedicação.', 0, 26, 26, NULL, NULL),
(127, 'A eficiência na administração pública busca:', 'Fazer mais com menos recursos.', 0, 27, 27, NULL, NULL),
(128, 'O princípio da anuidade orçamentária estabelece que:', NULL, 0, 28, 28, NULL, NULL),
(129, 'São receitas correntes do Estado:', NULL, 0, 29, 29, NULL, NULL),
(130, 'O parecer da auditoria pode ser classificado como:', NULL, 0, 30, 30, NULL, NULL),
(131, 'O comando SQL para remover uma tabela é:', 'DROP TABLE.', 0, 31, 31, NULL, NULL),
(132, 'No diagrama de classe da UML, a herança é representada por:', 'Uma seta com triângulo vazio.', 0, 32, 32, NULL, NULL),
(133, 'O endereço IPv4 é composto por quantos bits?', '32 bits.', 0, 33, 33, NULL, NULL),
(134, 'A criptografia assimétrica utiliza:', 'Um par de chaves (pública e privada).', 0, 34, 34, NULL, NULL),
(135, 'O COBIT 2019 foca principalmente em:', 'Governança e Gestão de TI.', 0, 35, 35, NULL, NULL),
(136, 'Em POO, o encapsulamento visa:', 'Proteger os dados internos do objeto.', 0, 36, 36, NULL, NULL),
(137, 'A identação em Python é:', 'Obrigatória para definir blocos.', 0, 37, 37, NULL, NULL),
(138, 'Uma pilha (Stack) segue a lógica:', 'LIFO (Last In, First Out).', 0, 38, 38, NULL, NULL),
(139, 'O comando "ls -l" no Linux serve para:', 'Listar arquivos com detalhes.', 0, 39, 39, NULL, NULL),
(140, 'As redes neurais artificiais são inspiradas em:', 'Neurônios biológicos.', 0, 40, 40, NULL, NULL),
(141, 'A Lei de Newton que trata da inércia é a:', 'Primeira Lei.', 0, 41, 41, NULL, NULL),
(142, 'Uma ligação iônica ocorre entre:', 'Metal e Ametal.', 0, 42, 42, NULL, NULL),
(143, 'O DNA é composto por quais bases nitrogenadas?', 'Adenina, Timina, Citosina, Guanina.', 0, 43, 43, NULL, NULL),
(144, 'A Constituição de 1824 foi outorgada por:', 'D. Pedro I.', 0, 44, 44, NULL, NULL),
(145, 'O bloco econômico do Mercosul inclui:', NULL, 0, 45, 45, NULL, NULL),
(146, 'A Guerra Fria foi um conflito ideológico entre:', 'EUA e URSS.', 0, 46, 46, NULL, NULL),
(147, 'A pontuação na CNH para suspensão pode variar conforme:', 'A gravidade das infrações.', 0, 47, 47, NULL, NULL),
(148, 'A rigidez cadavérica começa aproximadamente:', '2 a 4 horas após a morte.', 0, 48, 48, NULL, NULL),
(149, 'A Criminologia estuda o crime como um:', 'Fato social.', 0, 49, 49, NULL, NULL),
(150, 'O uso de pronomes de tratamento em redação oficial deve:', 'Seguir o Manual de Redação da Presidência.', 0, 50, 50, NULL, NULL);

-- =================================================================================
-- 4. TABELAS FINAIS (Alternativas e Respostas)
-- =================================================================================

-- Tabela: alternativa
INSERT INTO alternativa (id, texto, correta, id_questao) VALUES
(1, 'Alternativa A (Correta)', 1, 1), (2, 'Alternativa B (Errada)', 0, 1),
(3, 'Alternativa A (Errada)', 0, 2), (4, 'Alternativa B (Correta)', 1, 2),
(5, 'Alternativa A (Correta)', 1, 3), (6, 'Alternativa B (Errada)', 0, 3),
(7, 'Alternativa A (Errada)', 0, 4), (8, 'Alternativa B (Correta)', 1, 4),
(9, 'Alternativa A (Correta)', 1, 5), (10, 'Alternativa B (Errada)', 0, 5),
(11, 'Alt A', 1, 6), (12, 'Alt B', 0, 6), (13, 'Alt A', 1, 7), (14, 'Alt B', 0, 7),
(15, 'Alt A', 1, 8), (16, 'Alt B', 0, 8), (17, 'Alt A', 1, 9), (18, 'Alt B', 0, 9),
(19, 'Alt A', 1, 10), (20, 'Alt B', 0, 10), (21, 'Alt A', 1, 11), (22, 'Alt B', 0, 11),
(23, 'Alt A', 1, 12), (24, 'Alt B', 0, 12), (25, 'Alt A', 1, 13), (26, 'Alt B', 1, 13),
(27, 'Alt A', 1, 14), (28, 'Alt B', 0, 14), (29, 'Alt A', 1, 15), (30, 'Alt B', 0, 15),
(31, 'Alt A', 1, 16), (32, 'Alt B', 0, 16), (33, 'Alt A', 1, 17), (34, 'Alt B', 0, 17),
(35, 'Alt A', 0, 18), (36, 'Alt B', 0, 18), (37, 'Alt A', 1, 19), (38, 'Alt B', 1, 19),
(39, 'Alt A', 0, 20), (40, 'Alt B', 0, 20), (41, 'Alt A', 1, 21), (42, 'Alt B', 1, 21),
(43, 'Alt A', 0, 22), (44, 'Alt B', 0, 22), (45, 'Alt A', 1, 23), (46, 'Alt B', 1, 23),
(47, 'Alt A', 0, 24), (48, 'Alt B', 0, 24), (49, 'Alt A', 1, 25), (50, 'Alt B', 1, 25),
(51, 'Alt A', 0, 26), (52, 'Alt B', 0, 26), (53, 'Alt A', 1, 27), (54, 'Alt B', 1, 27),
(55, 'Alt A', 0, 28), (56, 'Alt B', 0, 28), (57, 'Alt A', 1, 29), (58, 'Alt B', 0, 29),
(59, 'Alt A', 0, 30), (60, 'Alt B', 0, 30), (61, 'Alt A', 1, 31), (62, 'Alt B', 0, 31),
(63, 'Alt A', 0, 32), (64, 'Alt B', 0, 32), (65, 'Alt A', 1, 33), (66, 'Alt B', 0, 33),
(67, 'Alt A', 0, 34), (68, 'Alt B', 0, 34), (69, 'Alt A', 1, 35), (70, 'Alt B', 0, 35),
(71, 'Alt A', 1, 36), (72, 'Alt B', 0, 36), (73, 'Alt A', 1, 37), (74, 'Alt B', 0, 37),
(75, 'Alt A', 1, 38), (76, 'Alt B', 0, 38), (77, 'Alt A', 1, 39), (78, 'Alt B', 0, 39),
(79, 'Alt A', 1, 40), (80, 'Alt B', 0, 40), (81, 'Alt A', 1, 41), (82, 'Alt B', 0, 41),
(83, 'Alt A', 1, 42), (84, 'Alt B', 0, 42), (85, 'Alt A', 1, 43), (86, 'Alt B', 0, 43),
(87, 'Alt A', 1, 44), (88, 'Alt B', 0, 44), (89, 'Alt A', 1, 45), (90, 'Alt B', 0, 45),
(91, 'Alt A', 1, 46), (92, 'Alt B', 0, 46), (93, 'Alt A', 1, 47), (94, 'Alt B', 0, 47),
(95, 'Alt A', 1, 48), (96, 'Alt B', 0, 48), (97, 'Alt A', 1, 49), (98, 'Alt B', 0, 49),
(99, 'Alt A', 1, 50), (100, 'Alt B', 0, 50),
(101, 'Alternativa Correta Q51', 1, 51), (102, 'Alternativa Errada Q51', 0, 51),
(103, 'Alternativa Errada Q52', 0, 52), (104, 'Alternativa Correta Q52', 1, 52),
(105, 'Alternativa Correta Q53', 1, 53), (106, 'Alternativa Errada Q53', 0, 53),
(107, 'Alternativa Errada Q54', 0, 54), (108, 'Alternativa Correta Q54', 1, 54),
(109, 'Alternativa Correta Q55', 1, 55), (110, 'Alternativa Errada Q55', 0, 55),
(111, 'Opção A (Certa)', 1, 56), (112, 'Opção B (Errada)', 0, 56),
(113, 'Opção A (Certa)', 1, 57), (114, 'Opção B (Errada)', 0, 57),
(115, 'Opção A (Certa)', 1, 58), (116, 'Opção B (Errada)', 0, 58),
(117, 'Opção A (Certa)', 1, 59), (118, 'Opção B (Errada)', 0, 59),
(119, 'Opção A (Certa)', 1, 60), (120, 'Opção B (Errada)', 0, 60),
(121, 'Opção A (Certa)', 1, 61), (122, 'Opção B (Errada)', 0, 61),
(123, 'Opção A (Certa)', 1, 62), (124, 'Opção B (Errada)', 0, 62),
(125, 'Opção A (Certa)', 1, 63), (126, 'Opção B (Errada)', 0, 63),
(127, 'Opção A (Certa)', 1, 64), (128, 'Opção B (Errada)', 0, 64),
(129, 'Opção A (Certa)', 1, 65), (130, 'Opção B (Errada)', 0, 65),
(131, 'Opção A (Certa)', 1, 66), (132, 'Opção B (Errada)', 0, 66),
(133, 'Opção A (Certa)', 1, 67), (134, 'Opção B (Errada)', 0, 67),
(135, 'Opção A (Certa)', 1, 68), (136, 'Opção B (Errada)', 0, 68),
(137, 'Opção A (Certa)', 1, 69), (138, 'Opção B (Errada)', 0, 69),
(139, 'Opção A (Certa)', 1, 70), (140, 'Opção B (Errada)', 0, 70),
(141, 'Opção A (Certa)', 1, 71), (142, 'Opção B (Errada)', 0, 71),
(143, 'Opção A (Certa)', 1, 72), (144, 'Opção B (Errada)', 0, 72),
(145, 'Opção A (Certa)', 1, 73), (146, 'Opção B (Errada)', 0, 73),
(147, 'Opção A (Certa)', 1, 74), (148, 'Opção B (Errada)', 0, 74),
(149, 'Opção A (Certa)', 1, 75), (150, 'Opção B (Errada)', 0, 75),
(151, 'Opção A (Certa)', 1, 76), (152, 'Opção B (Errada)', 0, 76),
(153, 'Opção A (Certa)', 1, 77), (154, 'Opção B (Errada)', 0, 77),
(155, 'Opção A (Certa)', 1, 78), (156, 'Opção B (Errada)', 0, 78),
(157, 'Opção A (Certa)', 1, 79), (158, 'Opção B (Errada)', 0, 79),
(159, 'Opção A (Certa)', 1, 80), (160, 'Opção B (Errada)', 0, 80),
(161, 'Opção A (Certa)', 1, 81), (162, 'Opção B (Errada)', 0, 81),
(163, 'Opção A (Certa)', 1, 82), (164, 'Opção B (Errada)', 0, 82),
(165, 'Opção A (Certa)', 1, 83), (166, 'Opção B (Errada)', 0, 83),
(167, 'Opção A (Certa)', 1, 84), (168, 'Opção B (Errada)', 0, 84),
(169, 'Opção A (Certa)', 1, 85), (170, 'Opção B (Errada)', 0, 85),
(171, 'Opção A (Certa)', 1, 86), (172, 'Opção B (Errada)', 0, 86),
(173, 'Opção A (Certa)', 1, 87), (174, 'Opção B (Errada)', 0, 87),
(175, 'Opção A (Certa)', 1, 88), (176, 'Opção B (Errada)', 0, 88),
(177, 'Opção A (Certa)', 1, 89), (178, 'Opção B (Errada)', 0, 89),
(179, 'Opção A (Certa)', 1, 90), (180, 'Opção B (Errada)', 0, 90),
(181, 'Opção A (Certa)', 1, 91), (182, 'Opção B (Errada)', 0, 91),
(183, 'Opção A (Certa)', 1, 92), (184, 'Opção B (Errada)', 0, 92),
(185, 'Opção A (Certa)', 1, 93), (186, 'Opção B (Errada)', 0, 93),
(187, 'Opção A (Certa)', 1, 94), (188, 'Opção B (Errada)', 0, 94),
(189, 'Opção A (Certa)', 1, 95), (190, 'Opção B (Errada)', 0, 95),
(191, 'Opção A (Certa)', 1, 96), (192, 'Opção B (Errada)', 0, 96),
(193, 'Opção A (Certa)', 1, 97), (194, 'Opção B (Errada)', 0, 97),
(195, 'Opção A (Certa)', 1, 98), (196, 'Opção B (Errada)', 0, 98),
(197, 'Opção A (Certa)', 1, 99), (198, 'Opção B (Errada)', 0, 99),
(199, 'Opção A (Certa)', 1, 100), (200, 'Opção B (Errada)', 0, 100),
(201, 'Opção A (Certa)', 1, 101), (202, 'Opção B (Errada)', 0, 101),
(203, 'Opção A (Certa)', 1, 102), (204, 'Opção B (Errada)', 0, 102),
(205, 'Opção A (Certa)', 1, 103), (206, 'Opção B (Errada)', 0, 103),
(207, 'Opção A (Certa)', 1, 104), (208, 'Opção B (Errada)', 0, 104),
(209, 'Opção A (Certa)', 1, 105), (210, 'Opção B (Errada)', 0, 105),
(211, 'Opção A (Certa)', 1, 106), (212, 'Opção B (Errada)', 0, 106),
(213, 'Opção A (Certa)', 1, 107), (214, 'Opção B (Errada)', 0, 107),
(215, 'Opção A (Certa)', 1, 108), (216, 'Opção B (Errada)', 0, 108),
(217, 'Opção A (Certa)', 1, 109), (218, 'Opção B (Errada)', 0, 109),
(219, 'Opção A (Certa)', 1, 110), (220, 'Opção B (Errada)', 0, 110),
(221, 'Opção A (Certa)', 1, 111), (222, 'Opção B (Errada)', 0, 111),
(223, 'Opção A (Certa)', 1, 112), (224, 'Opção B (Errada)', 0, 112),
(225, 'Opção A (Certa)', 1, 113), (226, 'Opção B (Errada)', 0, 113),
(227, 'Opção A (Certa)', 1, 114), (228, 'Opção B (Errada)', 0, 114),
(229, 'Opção A (Certa)', 1, 115), (230, 'Opção B (Errada)', 0, 115),
(231, 'Opção A (Certa)', 1, 116), (232, 'Opção B (Errada)', 0, 116),
(233, 'Opção A (Certa)', 1, 117), (234, 'Opção B (Errada)', 0, 117),
(235, 'Opção A (Certa)', 1, 118), (236, 'Opção B (Errada)', 0, 118),
(237, 'Opção A (Certa)', 1, 119), (238, 'Opção B (Errada)', 0, 119),
(239, 'Opção A (Certa)', 1, 120), (240, 'Opção B (Errada)', 0, 120),
(241, 'Opção A (Certa)', 1, 121), (242, 'Opção B (Errada)', 0, 121),
(243, 'Opção A (Certa)', 1, 122), (244, 'Opção B (Errada)', 0, 122),
(245, 'Opção A (Certa)', 1, 123), (246, 'Opção B (Errada)', 0, 123),
(247, 'Opção A (Certa)', 1, 124), (248, 'Opção B (Errada)', 0, 124),
(249, 'Opção A (Certa)', 1, 125), (250, 'Opção B (Errada)', 0, 125),
(251, 'Opção A (Certa)', 1, 126), (252, 'Opção B (Errada)', 0, 126),
(253, 'Opção A (Certa)', 1, 127), (254, 'Opção B (Errada)', 0, 127),
(255, 'Opção A (Certa)', 1, 128), (256, 'Opção B (Errada)', 0, 128),
(257, 'Opção A (Certa)', 1, 129), (258, 'Opção B (Errada)', 0, 129),
(259, 'Opção A (Certa)', 1, 130), (260, 'Opção B (Errada)', 0, 130),
(261, 'Opção A (Certa)', 1, 131), (262, 'Opção B (Errada)', 0, 131),
(263, 'Opção A (Certa)', 1, 132), (264, 'Opção B (Errada)', 0, 132),
(265, 'Opção A (Certa)', 1, 133), (266, 'Opção B (Errada)', 0, 133),
(267, 'Opção A (Certa)', 1, 134), (268, 'Opção B (Errada)', 0, 134),
(269, 'Opção A (Certa)', 1, 135), (270, 'Opção B (Errada)', 0, 135),
(271, 'Opção A (Certa)', 1, 136), (272, 'Opção B (Errada)', 0, 136),
(273, 'Opção A (Certa)', 1, 137), (274, 'Opção B (Errada)', 0, 137),
(275, 'Opção A (Certa)', 1, 138), (276, 'Opção B (Errada)', 0, 138),
(277, 'Opção A (Certa)', 1, 139), (278, 'Opção B (Errada)', 0, 139),
(279, 'Opção A (Certa)', 1, 140), (280, 'Opção B (Errada)', 0, 140),
(281, 'Opção A (Certa)', 1, 141), (282, 'Opção B (Errada)', 0, 141),
(283, 'Opção A (Certa)', 1, 142), (284, 'Opção B (Errada)', 0, 142),
(285, 'Opção A (Certa)', 1, 143), (286, 'Opção B (Errada)', 0, 143),
(287, 'Opção A (Certa)', 1, 144), (288, 'Opção B (Errada)', 0, 144),
(289, 'Opção A (Certa)', 1, 145), (290, 'Opção B (Errada)', 0, 145),
(291, 'Opção A (Certa)', 1, 146), (292, 'Opção B (Errada)', 0, 146),
(293, 'Opção A (Certa)', 1, 147), (294, 'Opção B (Errada)', 0, 147),
(295, 'Opção A (Certa)', 1, 148), (296, 'Opção B (Errada)', 0, 148),
(297, 'Opção A (Certa)', 1, 149), (298, 'Opção B (Errada)', 0, 149),
(299, 'Opção A (Certa)', 1, 150), (300, 'Opção B (Errada)', 0, 150);

-- Tabela: usuarioResposta
INSERT INTO usuario_resposta (id, data_resposta, id_usuario, id_questao, id_alternativa_escolhida) VALUES
(1, '2025-01-01', 1, 1, 1),
(2, '2025-01-02', 1, 2, 4),
(3, '2025-02-03', 1, 3, 6),
(4, '2025-02-04', 2, 1, 2),
(5, '2025-01-05', 2, 2, 4),
(6, '2025-01-01', 3, 6, 11), (7, '2025-01-01', 3, 7, 13), (8, '2025-01-01', 3, 8, 15),
(9, '2025-03-01', 4, 9, 17), (10, '2025-05-01', 4, 10, 19), (11, '2025-05-01', 5, 11, 21),
(12, '2025-03-01', 6, 12, 23), (13, '2025-05-01', 7, 13, 25), (14, '2025-05-01', 8, 14, 27),
(15, '2025-03-01', 9, 15, 29), (16, '2025-05-01', 10, 16, 31), (17, '2025-05-01', 11, 17, 33),
(18, '2025-03-01', 12, 18, 35), (19, '2025-05-01', 13, 19, 37), (20, '2025-05-01', 14, 20, 39),
(21, '2025-04-01', 15, 21, 41), (22, '2025-05-01', 16, 22, 43), (23, '2025-05-01', 17, 23, 45),
(24, '2025-04-01', 18, 24, 47), (25, '2025-05-01', 19, 25, 49), (26, '2025-05-01', 20, 26, 51),
(27, '2025-04-01', 21, 27, 53), (28, '2025-05-01', 22, 28, 55), (29, '2025-05-01', 23, 29, 57),
(30, '2025-04-01', 24, 30, 59), (31, '2025-05-01', 25, 31, 61), (32, '2025-05-01', 26, 32, 63),
(33, '2025-04-01', 27, 33, 65), (34, '2025-05-01', 28, 34, 67), (35, '2025-05-01', 29, 35, 69),
(36, '2025-05-01', 30, 36, 71), (37, '2025-05-01', 31, 37, 73), (38, '2024-05-01', 32, 38, 75),
(39, '2024-05-01', 33, 39, 77), (40, '2024-05-01', 34, 40, 79), (41, '2024-05-01', 35, 41, 81),
(42, '2024-05-01', 36, 42, 83), (43, '2024-05-01', 37, 43, 85), (44, '2024-05-01', 38, 44, 87),
(45, '2024-05-01', 39, 45, 89), (46, '2024-05-01', 40, 46, 91), (47, '2024-05-01', 41, 47, 93),
(48, '2024-05-01', 42, 48, 95), (49, '2024-05-01', 43, 49, 97), (50, '2024-05-01', 44, 50, 99);

-- =================================================================================
-- LOTE EXTRA: FOCANDO EM VOLUME POR DISCIPLINA (IDs 151 a 200)
-- =================================================================================

-- ---------------------------------------------------------------------------------
-- FOCO: LÍNGUA PORTUGUESA (Assunto ID 1) - Adicionando +10 questões
-- ---------------------------------------------------------------------------------
INSERT INTO questao (id, enunciado, comentario_professor, anulada, id_prova, id_assunto, data_anulacao) VALUES
(151, 'Assinale a alternativa em que o uso da crase é facultativo.', 'Casos de nomes próprios femininos.', 0, 1, 1, NULL),
(152, 'No trecho "A casa a qual me refiro", o pronome relativo deve ser craseado?', 'Sim, pois quem se refere, se refere A algo.', 0, 1, 1, NULL),
(153, 'Identifique a oração que apresenta erro de concordância verbal.', NULL, 0, 1, 1, NULL),
(154, 'A palavra "imprescindível" é acentuada por ser uma:', 'Paroxítona terminada em L.', 0, 1, 1, NULL),
(155, 'Em "Vende-se casas", a concordância correta deveria ser:', 'Vendem-se casas (voz passiva sintética).', 0, 1, 1, NULL),
(156, 'O uso da vírgula é obrigatório para separar:', 'O vocativo.', 0, 1, 1, NULL),
(157, 'Qual das palavras abaixo é formada por derivação parassintética?', NULL, 0, 1, 1, NULL),
(158, 'A regência do verbo "assistir" no sentido de ver exige preposição?', 'Sim, preposição A.', 0, 1, 1, NULL),
(159, 'Assinale a alternativa que contém uma figura de linguagem (Metáfora).', NULL, 0, 1, 1, NULL),
(160, 'O plural de "cidadão" é:', 'Cidadãos.', 0, 1, 1, NULL);

-- ---------------------------------------------------------------------------------
-- FOCO: INFORMÁTICA (Assunto ID 6 e 33) - Adicionando +8 questões
-- ---------------------------------------------------------------------------------
INSERT INTO questao (id, enunciado, comentario_professor, anulada, id_prova, id_assunto, data_anulacao) VALUES
(161, 'No Excel, a função SE serve para:', 'Testes lógicos.', 0, 6, 6, NULL),
(162, 'Para fixar uma célula numa fórmula do Excel, utilizamos o caractere:', 'Cifrão ($).', 0, 6, 6, NULL),
(163, 'Qual protocolo é responsável pelo envio de e-mails?', 'SMTP.', 0, 11, 33, NULL),
(164, 'O protocolo HTTPS utiliza qual porta padrão?', '443.', 0, 11, 33, NULL),
(165, 'Um Ransomware é um tipo de malware que:', 'Sequestra dados criptografando-os.', 0, 11, 33, NULL),
(166, 'O conceito de Computação em Nuvem (Cloud Computing) refere-se a:', NULL, 0, 6, 6, NULL),
(167, 'No Word, o atalho Ctrl+Z serve para:', 'Desfazer a última ação.', 0, 6, 6, NULL),
(168, 'O endereço IP 192.168.0.1 é considerado um endereço de classe:', 'Classe C (Privado).', 0, 11, 33, NULL);

-- ---------------------------------------------------------------------------------
-- FOCO: DIREITO CONSTITUCIONAL (Assunto ID 4) - Adicionando +7 questões
-- ---------------------------------------------------------------------------------
INSERT INTO questao (id, enunciado, comentario_professor, anulada, id_prova, id_assunto, data_anulacao) VALUES
(169, 'É livre a manifestação do pensamento, sendo vedado:', 'O anonimato.', 0, 4, 4, NULL),
(170, 'A casa é asilo inviolável, ninguém nela podendo penetrar sem consentimento, salvo:', 'Flagrante delito, desastre ou socorro.', 0, 4, 4, NULL),
(171, 'São privativos de brasileiro nato os cargos de:', 'Presidente, Vice, Pres. Câmara, Pres. Senado, Min. STF.', 0, 4, 4, NULL),
(172, 'O mandado de segurança coletivo pode ser impetrado por:', NULL, 0, 4, 4, NULL),
(173, 'A soberania popular será exercida pelo sufrágio universal e pelo voto:', 'Direto e secreto.', 0, 4, 4, NULL),
(174, 'Nenhum brasileiro será extraditado, salvo o naturalizado, em caso de:', 'Crime comum antes da naturalização ou tráfico.', 0, 4, 4, NULL),
(175, 'A defesa da paz e a solução pacífica dos conflitos são princípios das:', 'Relações Internacionais.', 0, 4, 4, NULL);

-- ---------------------------------------------------------------------------------
-- FOCO: MATEMÁTICA E RLM (Assunto ID 2 e 3) - Adicionando +6 questões
-- ---------------------------------------------------------------------------------
INSERT INTO questao (id, enunciado, comentario_professor, anulada, id_prova, id_assunto, data_anulacao) VALUES
(176, 'Se 5 operários fazem um muro em 10 dias, 10 operários farão em:', 'Regra de três inversa (5 dias).', 0, 2, 2, NULL),
(177, 'O volume de um cubo de aresta 3cm é:', '27 cm³.', 0, 2, 2, NULL),
(178, 'Em uma PG de razão 2, se o primeiro termo é 3, o quarto termo é:', '24.', 0, 2, 2, NULL),
(179, 'A negação de "Chove e faz frio" é:', 'Não chove OU não faz frio.', 0, 3, 3, NULL),
(180, 'Se todo A é B, e algum C é A, logo:', 'Algum C é B.', 0, 3, 3, NULL),
(181, 'Qual a probabilidade de tirar um Ás em um baralho de 52 cartas?', '4/52 ou 1/13.', 0, 2, 2, NULL);

-- ---------------------------------------------------------------------------------
-- DIVERSOS (PROGRAMAÇÃO E OUTROS) - Adicionando +19 questões mistas
-- ---------------------------------------------------------------------------------
INSERT INTO questao (id, enunciado, comentario_professor, anulada, id_prova, id_assunto, data_anulacao) VALUES
(182, 'Em Java, qual palavra-chave impede que uma classe seja herdada?', 'Final.', 0, 36, 36, NULL),
(183, 'O método main em Java deve ser obrigatoriamente:', 'public static void.', 0, 36, 36, NULL),
(184, 'Qual estrutura de dados utiliza o conceito FIFO?', 'Fila (Queue).', 0, 38, 38, NULL),
(185, 'Em Python, qual símbolo inicia um comentário?', '#.', 0, 37, 37, NULL),
(186, 'O comando Git para enviar alterações para o repositório remoto é:', 'git push.', 0, 32, 32, NULL),
(187, 'Sobre o Docker, é correto afirmar que ele utiliza:', 'Containers.', 0, 32, 32, NULL),
(188, 'O principal objetivo da normalização de dados é:', 'Reduzir redundância.', 0, 31, 31, NULL),
(189, 'No modelo OSI, a camada física trata de:', 'Bits e transmissão elétrica.', 0, 33, 33, NULL),
(190, 'O Linux é um sistema operacional de código:', 'Aberto (Open Source).', 0, 39, 39, NULL),
(191, 'A Lei 8.112/90 dispõe sobre:', 'O regime jurídico dos servidores federais.', 0, 5, 5, NULL),
(192, 'Qual o prazo de validade máximo de um concurso público?', '2 anos, prorrogável por igual período.', 0, 5, 5, NULL),
(193, 'A responsabilidade civil do Estado é, via de regra:', 'Objetiva.', 0, 5, 5, NULL),
(194, 'O ato administrativo pode ser revogado por motivos de:', 'Conveniência e oportunidade.', 0, 5, 5, NULL),
(195, 'Quem descobriu o Brasil?', 'Pedro Álvares Cabral.', 0, 44, 44, NULL),
(196, 'A capital do Brasil antes de Brasília era:', 'Rio de Janeiro.', 0, 44, 44, NULL),
(197, 'O maior país da América do Sul em extensão é:', 'Brasil.', 0, 45, 45, NULL),
(198, 'A moeda oficial dos Estados Unidos é:', 'Dólar.', 0, 11, 11, NULL),
(199, 'A velocidade da luz é de aproximadamente:', '300.000 km/s.', 0, 41, 41, NULL),
(200, 'A fórmula química da água é:', 'H2O.', 0, 42, 42, NULL);

-- =================================================================================
-- ALTERNATIVAS PARA O LOTE EXTRA (IDs 301 a 400)
-- 2 Alternativas por questão para economizar linhas, mantendo funcionalidade
-- =================================================================================

INSERT INTO alternativa (id, texto, correta, id_questao) VALUES
-- Português
(301, 'À Maria (Certa)', 1, 151), (302, 'A Maria (Errada)', 0, 151),
(303, 'A qual (Errada)', 0, 152), (304, 'À qual (Certa)', 1, 152),
(305, 'Fazem dias (Certa - Erro)', 1, 153), (306, 'Faz dias (Errada - Correto)', 0, 153),
(307, 'Oxítona (Errada)', 0, 154), (308, 'Proparoxítona (Certa)', 1, 154),
(309, 'Vendem-se (Certa)', 1, 155), (310, 'Vende-se (Errada)', 0, 155),
(311, 'Sujeito (Errada)', 0, 156), (312, 'Vocativo (Certa)', 1, 156),
(313, 'Anoitecer (Certa)', 1, 157), (314, 'Felizmente (Errada)', 0, 157),
(315, 'Sim (Certa)', 1, 158), (316, 'Não (Errada)', 0, 158),
(317, 'Coração de pedra (Certa)', 1, 159), (318, 'Correu rápido (Errada)', 0, 159),
(319, 'Cidadões (Errada)', 0, 160), (320, 'Cidadãos (Certa)', 1, 160),
-- Informática
(321, 'Condição (Certa)', 1, 161), (322, 'Soma (Errada)', 0, 161),
(323, '$ (Certa)', 1, 162), (324, '# (Errada)', 0, 162),
(325, 'POP3 (Errada)', 0, 163), (326, 'SMTP (Certa)', 1, 163),
(327, '80 (Errada)', 0, 164), (328, '443 (Certa)', 1, 164),
(329, 'Criptografa (Certa)', 1, 165), (330, 'Apaga (Errada)', 0, 165),
(331, 'Servidor Local (Errada)', 0, 166), (332, 'Internet (Certa)', 1, 166),
(333, 'Salvar (Errada)', 0, 167), (334, 'Desfazer (Certa)', 1, 167),
(335, 'Pública (Errada)', 0, 168), (336, 'Privada (Certa)', 1, 168),
-- Constitucional
(337, 'Anonimato (Certa)', 1, 169), (338, 'Crítica (Errada)', 0, 169),
(339, 'Dia ou Noite (Errada)', 0, 170), (340, 'Dia c/ mandado (Certa)', 1, 170),
(341, 'Deputado Federal (Errada)', 0, 171), (342, 'Presidente (Certa)', 1, 171),
(343, 'Cidadão (Errada)', 0, 172), (344, 'Partido Político (Certa)', 1, 172),
(345, 'Direto e Secreto (Certa)', 1, 173), (346, 'Indireto e Aberto (Errada)', 0, 173),
(347, 'Tráfico (Certa)', 1, 174), (348, 'Furto (Errada)', 0, 174),
(349, 'Internacionais (Certa)', 1, 175), (350, 'Administrativas (Errada)', 0, 175),
-- Matemática/RLM
(351, '20 dias (Errada)', 0, 176), (352, '5 dias (Certa)', 1, 176),
(353, '9 (Errada)', 0, 177), (354, '27 (Certa)', 1, 177),
(355, '24 (Certa)', 1, 178), (356, '12 (Errada)', 0, 178),
(357, 'Não chove e não faz frio (Errada)', 0, 179), (358, 'Não chove ou não faz frio (Certa)', 1, 179),
(359, 'Algum C é B (Certa)', 1, 180), (360, 'Nenhum C é B (Errada)', 0, 180),
(361, '1/13 (Certa)', 1, 181), (362, '1/52 (Errada)', 0, 181),
-- Diversos
(363, 'Static (Errada)', 0, 182), (364, 'Final (Certa)', 1, 182),
(365, 'Void (Certa)', 1, 183), (366, 'Int (Errada)', 0, 183),
(367, 'Fila (Certa)', 1, 184), (368, 'Pilha (Errada)', 0, 184),
(369, '// (Errada)', 0, 185), (370, '# (Certa)', 1, 185),
(371, 'Pull (Errada)', 0, 186), (372, 'Push (Certa)', 1, 186),
(373, 'VMs (Errada)', 0, 187), (374, 'Containers (Certa)', 1, 187),
(375, 'Redundância (Certa)', 1, 188), (376, 'Performance (Errada)', 0, 188),
(377, 'Lógica (Errada)', 0, 189), (378, 'Física (Certa)', 1, 189),
(379, 'Fechado (Errada)', 0, 190), (380, 'Aberto (Certa)', 1, 190),
(381, 'CLT (Errada)', 0, 191), (382, 'Estatutário (Certa)', 1, 191),
(383, '1 ano (Errada)', 0, 192), (384, '2 anos (Certa)', 1, 192),
(385, 'Subjetiva (Errada)', 0, 193), (386, 'Objetiva (Certa)', 1, 193),
(387, 'Ilegalidade (Errada)', 0, 194), (388, 'Conveniência (Certa)', 1, 194),
(389, 'Cabral (Certa)', 1, 195), (390, 'Colombo (Errada)', 0, 195),
(391, 'Salvador (Errada)', 0, 196), (392, 'Rio de Janeiro (Certa)', 1, 196),
(393, 'Argentina (Errada)', 0, 197), (394, 'Brasil (Certa)', 1, 197),
(395, 'Euro (Errada)', 0, 198), (396, 'Dólar (Certa)', 1, 198),
(397, 'Som (Errada)', 0, 199), (398, 'Luz (Certa)', 1, 199),
(399, 'CO2 (Errada)', 0, 200), (400, 'H2O (Certa)', 1, 200);

-- =================================================================================
-- 5. LOTE ADICIONAL: PROVAS EXTRAS PARA CONCURSOS EXISTENTES (Teste UC-02)
-- =================================================================================

-- Adicionando mais provas ao Concurso PF 2024 (ID 1) que já tinha a Prova 1
INSERT INTO prova (id, nome, data_aplicacao, id_concurso, id_cargo) VALUES
(51, 'Prova Objetiva PF Escrivão', '2024-02-01', 1, 6),   -- Mesmo concurso, outro cargo
(52, 'Prova Objetiva PF Delegado', '2024-02-01', 1, 5),   -- Mesmo concurso, outro cargo
(53, 'Prova Discursiva PF Geral', '2024-03-15', 1, 1);    -- Outra data

-- Adicionando mais provas ao Concurso Caixa 2024 (ID 5) que já tinha a Prova 5
INSERT INTO prova (id, nome, data_aplicacao, id_concurso, id_cargo) VALUES
(54, 'Prova Objetiva Caixa TI', '2024-04-01', 5, 12),     -- Cargo de TI
(55, 'Prova Objetiva Caixa Engenharia', '2024-04-01', 5, 14); -- Cargo de Engenheiro

-- Adicionando mais provas ao Concurso Receita 2024 (ID 2)
INSERT INTO prova (id, nome, data_aplicacao, id_concurso, id_cargo) VALUES
(56, 'Prova Analista Tributário', '2024-02-01', 2, 4);

-- =================================================================================
-- 6. QUESTÕES ADICIONAIS COM FOCAL EM ANULAÇÃO (Teste UC-03)
-- =================================================================================

-- Questões para a Prova de Escrivão PF (ID 51)
INSERT INTO questao (id, enunciado, comentario_professor, anulada, id_prova, id_assunto, data_anulacao) VALUES
(201, 'Questão sobre Inquérito Policial para Escrivão.', NULL, 0, 51, 14, NULL),
(202, 'Questão anulada de Escrivão (Data coincidente).', 'Erro material no enunciado.', 1, 51, 14, '2024-05-25'), -- Mesma data da Questão 1
(203, 'Questão anulada de Escrivão (Outra data).', 'Gabarito incorreto.', 1, 51, 14, '2024-06-10');

-- Questões para a Prova de TI da Caixa (ID 54)
INSERT INTO questao (id, enunciado, comentario_professor, anulada, id_prova, id_assunto, data_anulacao) VALUES
(204, 'Questão sobre Java e Polimorfismo.', NULL, 0, 54, 36, NULL),
(205, 'Questão de Banco de Dados anulada.', 'Comando SQL ambíguo.', 1, 54, 31, '2024-04-15'),
(206, 'Questão de Segurança da Informação.', NULL, 0, 54, 34, NULL);

-- Questão com Texto Longo (CLOB) para testar sua Projeção
INSERT INTO questao (id, enunciado, comentario_professor, anulada, id_prova, id_assunto, data_anulacao) VALUES
(207, 'Texto Longo: Considerando a Lei 8.112/90, analise a situação hipotética onde um servidor público federal, no exercício de suas atribuições, causa dano a terceiros. Neste caso, a responsabilidade civil do Estado será objetiva, sob a modalidade do risco administrativo, assegurado o direito de regresso contra o responsável nos casos de dolo ou culpa. Com base nisso, julgue os itens a seguir sobre a prescrição da ação disciplinar.',
'O comentário do professor também é longo para testar a leitura do CLOB no Java. A questão foi anulada pois o texto base continha informações contraditórias com a jurisprudência atual do STF sobre o tema de responsabilidade civil.',
1, 52, 5, '2024-02-15');

-- =================================================================================
-- 7. ALTERNATIVAS PARA AS NOVAS QUESTÕES
-- =================================================================================

INSERT INTO alternativa (id, texto, correta, id_questao) VALUES
(401, 'Certo', 1, 201), (402, 'Errado', 0, 201),
(403, 'Certo', 1, 202), (404, 'Errado', 0, 202),
(405, 'Certo', 1, 203), (406, 'Errado', 0, 203),
(407, 'Certo', 1, 204), (408, 'Errado', 0, 204),
(409, 'Certo', 1, 205), (410, 'Errado', 0, 205),
(411, 'Certo', 1, 206), (412, 'Errado', 0, 206),
(413, 'Certo', 1, 207), (414, 'Errado', 0, 207);

-- =================================================================================
-- 8. MASSA DE DADOS PARA UC-07 (EVOLUÇÃO DO ALUNO ID 3)
-- =================================================================================

-- CENÁRIO 1: INFORMÁTICA (Assunto: Excel - ID 6) -> ALTA PERFORMANCE (100%)
-- O aluno acertou todas as questões que tentou.
INSERT INTO usuario_resposta (id, data_resposta, id_usuario, id_questao, id_alternativa_escolhida) VALUES
(51, '2025-06-01', 3, 161, 321), -- Q161 (Excel): Escolheu 321 (Correta)
(52, '2025-06-02', 3, 162, 323), -- Q162 (Excel): Escolheu 323 (Correta)
(53, '2025-06-03', 3, 68, 135),  -- Q68 (Excel): Escolheu 135 (Correta)
(54, '2025-06-04', 3, 167, 334); -- Q167 (Word/Office): Escolheu 334 (Correta)

-- CENÁRIO 2: LÍNGUA PORTUGUESA (Assunto: Crase - ID 1) -> BAIXA PERFORMANCE (25%)
-- O aluno errou 3 e acertou 1.
INSERT INTO usuario_resposta (id, data_resposta, id_usuario, id_questao, id_alternativa_escolhida) VALUES
(55, '2025-06-05', 3, 151, 302), -- Q151 (Crase): Escolheu 302 (ERRADA)
(56, '2025-06-06', 3, 152, 303), -- Q152 (Crase): Escolheu 303 (ERRADA)
(57, '2025-06-07', 3, 63, 126),  -- Q63 (Crase): Escolheu 126 (ERRADA)
(58, '2025-06-08', 3, 1, 1);     -- Q1 (Crase): Escolheu 1 (CORRETA)

-- CENÁRIO 3: MATEMÁTICA (Assunto: Porcentagem/Matemática Básica - ID 2) -> MÉDIA PERFORMANCE (50%)
-- O aluno acertou 2 e errou 2.
INSERT INTO usuario_resposta (id, data_resposta, id_usuario, id_questao, id_alternativa_escolhida) VALUES
(59, '2025-06-09', 3, 2, 4),     -- Q2 (Porcentagem): Escolheu 4 (CORRETA)
(60, '2025-06-10', 3, 176, 352), -- Q176 (Regra de Três): Escolheu 352 (CORRETA)
(61, '2025-06-11', 3, 177, 353), -- Q177 (Volume): Escolheu 353 (ERRADA)
(62, '2025-06-12', 3, 178, 356); -- Q178 (PG): Escolheu 356 (ERRADA)

-- CENÁRIO 4: DIREITO CONSTITUCIONAL (Assunto: Direitos Fundamentais - ID 4) -> BOA PERFORMANCE
-- O aluno acertou 2 e errou 1.
INSERT INTO usuario_resposta (id, data_resposta, id_usuario, id_questao, id_alternativa_escolhida) VALUES
(63, '2025-06-13', 3, 4, 8),     -- Q4 (Dir. Fund.): Escolheu 8 (CORRETA)
(64, '2025-06-14', 3, 169, 337), -- Q169 (Anonimato): Escolheu 337 (CORRETA)
(65, '2025-06-15', 3, 170, 339); -- Q170 (Casa Asilo): Escolheu 339 (ERRADA)

-- CENÁRIO 5: DIVERSOS (Para popular a lista e testar paginação)
INSERT INTO usuario_resposta (id, data_resposta, id_usuario, id_questao, id_alternativa_escolhida) VALUES
(66, '2025-06-16', 3, 182, 364), -- Java (Correta)
(67, '2025-06-17', 3, 183, 366), -- Java (Errada)
(68, '2025-06-18', 3, 189, 378), -- Redes (Correta)
(69, '2025-06-19', 3, 195, 389), -- História (Correta)
(70, '2025-06-20', 3, 196, 391); -- História (Errada)

UPDATE questao SET data_criacao = '2025-01-01' WHERE data_criacao IS NULL;
