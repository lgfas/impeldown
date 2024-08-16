package com.lgfas.impeldown.repository;

import com.lgfas.impeldown.model.Guarda;
import com.lgfas.impeldown.model.enums.Posto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GuardaRepository {

    private final JdbcTemplate jdbcTemplate;

    public GuardaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void cadastrarGuarda(Guarda guarda) {
        String sql = """
                
                INSERT INTO
                    tb_guarda (nome, posto)
                VALUES
                    (?, ?)
                
                """;

        jdbcTemplate.update(
                sql,
                guarda.getNome(),
                guarda.getPosto().name()
        );
    }

    public Guarda buscarGuardaPorId(Long id) {
        String sql = """
                
                SELECT
                    tb_guarda.id as id,
                    tb_guarda.nome as nome,
                    tb_guarda.posto as posto
                FROM
                    tb_guarda
                WHERE
                    id=?
                
                """;

        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) -> new Guarda(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        Posto.valueOf(rs.getString("posto"))
                ),
                id
        );
    }

    public List<Guarda> buscarGuardas() {
        String sql = """
                
                SELECT
                    tb_guarda.id as id,
                    tb_guarda.nome as nome,
                    tb_guarda.posto as posto
                FROM
                    tb_guarda
                
                """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Guarda(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        Posto.valueOf(rs.getString("posto"))
                )
        );
    }

    public void atualizarGuarda(Long id, Guarda guarda) {
        String sql = """
                
                UPDATE
                    tb_guarda
                SET
                    nome=?,
                    posto=?
                WHERE
                    id = ?
                
                """;

        jdbcTemplate.update(
                sql,
                guarda.getNome(),
                guarda.getPosto().name(),
                id
        );
    }

    public void removerGuarda(Long id) {
        String sql = """
                
                DELETE FROM
                   tb_guarda
                WHERE
                    id = ?
                
                """;

        jdbcTemplate.update(
                sql,
                id
        );
    }
}
