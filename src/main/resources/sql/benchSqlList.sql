select
	tf.nome as name,
	tf.Abrev as id,
	CASE tcw.Status
		WHEN 1 THEN 'Alocado'
		WHEN 2 THEN 'Alocação Futura'
		WHEN 3 THEN 'Sem Alocação'
		WHEN 4 THEN 'Proposto'
		WHEN 5 THEN 'Renovação'
		WHEN 6 THEN 'Reservado'
		ELSE 'Outro' END AS status,
	tf.Familia as family,
	tf.Nivel as level,
	tf.Cidade as  city,
	tf.Localizacao as location,
	tfc.Conhecimento as skill,
	CASE tfc.Nivel
		WHEN 1 THEN 'Baixo'
		WHEN 2 THEN 'Médio'
		WHEN 3 THEN 'Alto'
		ELSE 'Outro' END as skill_level,
	tfi.idioma as language,
	CASE tfi.Nivel
		WHEN 1 THEN 'Baixo'
		WHEN 2 THEN 'Médio'
		WHEN 3 THEN 'Alto'
		ELSE 'Outro' END AS language_level
	from tb_controle_wa tcw
	inner join tb_funcionario tf on tcw.ID_FUN = tf.ID_FUN
	left join tb_fun_conhecimentos tfc on tf.ID_FUN = tfc.ID_FUN
	left join tb_fun_idiomas tfi on tf.ID_FUN = tfi.ID_FUN