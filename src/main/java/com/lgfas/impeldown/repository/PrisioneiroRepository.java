package com.lgfas.impeldown.repository;

import com.lgfas.impeldown.model.Prisioneiro;
import com.lgfas.impeldown.model.enums.NivelPerigo;
import com.lgfas.impeldown.model.enums.NivelSeguranca;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrisioneiroRepository {

    private final JdbcTemplate jdbcTemplate;

    public PrisioneiroRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static RowMapper<Prisioneiro> getPrisioneiroRowMapper() {
        return (rs, rowNum) -> new Prisioneiro(
                rs.getLong("id"),
                rs.getString("nome"),
                rs.getInt("idade"),
                NivelPerigo.valueOf(rs.getString("nivelPerigo")),
                rs.getString("crime"),
                NivelSeguranca.valueOf(rs.getString("nivelSeguranca"))
        );
    }

    public void cadastrarPrisioneiro(Prisioneiro prisioneiro) {
        String sql = """
                
                INSERT INTO
                    tb_prisioneiro (nome, idade, nivel_perigo, crime, nivel_seguranca)
                VALUES (?, ?, ?, ?, ?)
                
                """;

        jdbcTemplate.update(
                sql,
                prisioneiro.getNome(),
                prisioneiro.getIdade(),
                prisioneiro.getNivelPerigo().name(),
                prisioneiro.getCrime(),
                prisioneiro.getNivelSeguranca().name()
        );
    }

    public Prisioneiro buscarPrisioneiroPorId(Long id) {
        String sql = """
                
                SELECT
                    tb_prisioneiro.id as id,
                    tb_prisioneiro.nome as nome,
                    tb_prisioneiro.idade as idade,
                    tb_prisioneiro.nivel_perigo as nivelPerigo,
                    tb_prisioneiro.crime as crime,
                    tb_prisioneiro.nivel_seguranca as nivelSeguranca
                FROM
                    tb_prisioneiro
                WHERE
                    id = ?
                
                """;

        return jdbcTemplate.queryForObject(
                sql,
                getPrisioneiroRowMapper(),
                id
        );
    }

    public List<Prisioneiro> buscarPrisioneiros(int pagina, int tamanhoPagina) {
        // Calcula o valor do offset
        int offset = (pagina - 1) * tamanhoPagina;

        String sql = """
            SELECT
                tb_prisioneiro.id as id,
                tb_prisioneiro.nome as nome,
                tb_prisioneiro.idade as idade,
                tb_prisioneiro.nivel_perigo as nivelPerigo,
                tb_prisioneiro.crime as crime,
                tb_prisioneiro.nivel_seguranca as nivelSeguranca
            FROM
                tb_prisioneiro
            LIMIT ? OFFSET ?
            """;

        // Executa a consulta com paginação
        return jdbcTemplate.query(
                sql,
                new Object[]{tamanhoPagina, offset},
                getPrisioneiroRowMapper()
        );
    }


    public void autalizarPrisioneiro(Long id, Prisioneiro prisioneiro) {
        String sql = """
                
                UPDATE
                    tb_prisioneiro
                SET
                    nome = ?,
                    idade = ?,
                    nivel_perigo = ?,
                    crime = ?,
                    nivel_seguranca = ?
                WHERE
                    id = ?

                """;

        jdbcTemplate.update(
                sql,
                prisioneiro.getNome(),
                prisioneiro.getIdade(),
                prisioneiro.getNivelPerigo().name(),
                prisioneiro.getCrime(),
                prisioneiro.getNivelSeguranca().name(),
                id
        );
    }

    public void removerPrisioneiro(Long id) {
        String sql = """
                
                DELETE FROM
                    tb_prisioneiro
                WHERE
                    id = ?
                
                """;

        jdbcTemplate.update(
                sql,
                id
        );
    }
}
