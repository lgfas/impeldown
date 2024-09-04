package com.lgfas.impeldown.repository;

import com.lgfas.impeldown.model.Prisioneiro;
import com.lgfas.impeldown.model.Transferencia;
import com.lgfas.impeldown.model.enums.NivelSeguranca;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransferenciaRepository {

    private final JdbcTemplate jdbcTemplate;
    private final PrisioneiroRepository prisioneiroRepository;

    public TransferenciaRepository(JdbcTemplate jdbcTemplate, PrisioneiroRepository prisioneiroRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.prisioneiroRepository = prisioneiroRepository;
    }


    private RowMapper<Transferencia> getTransferenciaRowMapper() {


        return (rs, rowNum) -> {
            Long prisioneiroId = rs.getLong("prisioneiro");
            Prisioneiro prisioneiro = prisioneiroRepository.buscarPrisioneiroPorId(prisioneiroId);

            return new Transferencia(
                    rs.getLong("id"),
                    prisioneiro,
                    NivelSeguranca.valueOf(rs.getString("nivelOrigem")),
                    NivelSeguranca.valueOf(rs.getString("nivelDestino")),
                    rs.getTimestamp("dataTransferencia").toLocalDateTime()
            );
        };
    }

    public void cadastrarTransferencia(Transferencia transferencia) {
        String sql = """
                
                INSERT INTO
                    tb_transferencia(prisioneiro_id, nivel_origem, nivel_destino, data_transferencia)
                VALUES (?, ?, ?, ?)
                """;

        jdbcTemplate.update(
                sql,
                transferencia.getPrisioneiro().getId(),
                transferencia.getNivelOrigem().name(),
                transferencia.getNivelDestino().name(),
                transferencia.getDataTransferencia()
        );
    }

    public Transferencia buscarTransferenciaPorId(Long id) {
        String sql = """
                
                SELECT
                    tb_transferencia.id,
                    tb_transferencia.prisioneiro_id prisioneiro,
                    tb_transferencia.nivel_origem nivelOrigem,
                    tb_transferencia.nivel_destino nivelDestino,
                    tb_transferencia.data_transferencia dataTransferencia
                FROM
                    tb_transferencia
                WHERE
                    id = ?
                
                """;

        return jdbcTemplate.queryForObject(
                sql,
                getTransferenciaRowMapper(),
                id
        );
    }

    public List<Transferencia> buscarTransferencias(int pagina, int tamanhoPagina) {
        int offset = (pagina - 1) * tamanhoPagina;

        String sql = """
            SELECT
                    tb_transferencia.id,
                    tb_transferencia.prisioneiro_id prisioneiro,
                    tb_transferencia.nivel_origem nivelOrigem,
                    tb_transferencia.nivel_destino nivelDestino,
                    tb_transferencia.data_transferencia dataTransferencia
                FROM
                    tb_transferencia
            LIMIT ? OFFSET ?
            """;

        return jdbcTemplate.query(
                sql,
                new Object[]{tamanhoPagina, offset},
                getTransferenciaRowMapper()
        );
    }

    public void atualizarTransferencia(Long id, Transferencia transferencia) {
        String sql = """
                
                UPDATE
                    tb_transferencia
                SET
                    prisioneiro_id = ?,
                    nivel_origem = ?,
                    nivel_destino = ?,
                    data_transferencia = ?
                WHERE
                    id = ?
                
                """;

        jdbcTemplate.update(
                sql,
                transferencia.getPrisioneiro().getId(),
                transferencia.getNivelOrigem().name(),
                transferencia.getNivelDestino().name(),
                transferencia.getDataTransferencia(),
                id
        );
    }

    public void removerTransferencia(Long id) {
        String sql = """
                
                DELETE FROM
                    tb_transferencia
                WHERE
                    id = ?
                
                """;

        jdbcTemplate.update(
                sql,
                id
        );
    }
}
