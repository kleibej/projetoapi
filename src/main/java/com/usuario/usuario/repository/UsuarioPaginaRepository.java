package com.usuario.usuario.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.usuario.usuario.models.Usuario;

@Repository
public interface UsuarioPaginaRepository extends PagingAndSortingRepository<Usuario, Long>{
}
