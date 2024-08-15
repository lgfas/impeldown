package com.lgfas.impeldown.repository;

import com.lgfas.impeldown.model.Administrador;
import com.lgfas.impeldown.model.enums.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdministradorRepository {

    private final JdbcTemplate jdbcTemplate;

    public AdministradorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void cadastrarAdministrador(Administrador administrador) {
        String sql = """
                
                INSERT INTO
                    tb_administrador (nome, cargo)
                VALUES
                    (?,?)
                
                """;

        jdbcTemplate.update(
                sql,
                administrador.getNome(),
                administrador.getCargo().name()
        );
    }

    public Administrador buscarAdministradorPorId(Long id) {
        String sql = """
                
                SELECT
                    tb_administrador.id as id,
                    tb_administrador.nome as nome,
                    tb_administrador.cargo as cargo
                FROM
                    tb_administrador
                WHERE
                    id = ?
                
                """;

        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) -> new Administrador(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        Cargo.valueOf(rs.getString("cargo"))
                ),
                id
        );
    }

    public List<Administrador> buscarAdministradores() {
        String sql = """
                
                SELECT
                    tb_administrador.id as id,
                    tb_administrador.nome as nome,
                    tb_administrador.cargo as cargo
                FROM
                    tb_administrador
                
                """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Administrador(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        Cargo.valueOf(rs.getString("cargo"))
                )
        );
    }

    public void atualizarAdministrador(Long id, Administrador administrador) {
        String sql = """
                
                UPDATE
                    tb_administrador
                SET
                    nome = ?,
                    cargo = ?
                WHERE
                    id = ?

                """;

        jdbcTemplate.update(
                sql,
                administrador.getNome(),
                administrador.getCargo().name(),
                id
        );
    }

    public void removerAdministrador(Long id) {
        String sql = """
                
                DELETE FROM
                   tb_administrador
                WHERE
                    id = ?
                
                """;

        jdbcTemplate.update(
                sql,
                id
        );
    }
}
