package com.usuario.usuario.resource;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.usuario.usuario.models.Usuario;
import com.usuario.usuario.repository.UsuarioPaginaRepository;
import com.usuario.usuario.repository.UsuarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="API REST Usuarios")
@CrossOrigin(origins="*")
public class UsuarioResource implements CommandLineRunner  {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	UsuarioPaginaRepository usuarioPaginaRepository;
	
	//lista para inserir os dados da csv
	List<Usuario> usuarios = new ArrayList<>();
	
	//Trata o csv e coloca em uma lista
	@Override
	public void run(String... args) throws Exception {
		Reader reader = Files.newBufferedReader(Paths.get("c:\\temp\\carga_usuarios.csv"));
	    CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
	    int x;
	    int y;
	    char sexo;
	    List<String[]> pessoas = csvReader.readAll();
	    Usuario p; 
	    for (String[] pessoa : pessoas) {
	    	sexo = ' ';
	    	x= Integer.parseInt(pessoa[3]);
	    	y = Integer.parseInt(pessoa[8]);
	    	if("M".equals(pessoa[4])|| "m".equals(pessoa[4]) || "f".equals(pessoa[4]) || "F".equals(pessoa[4])) {
	    		sexo = pessoa[4].charAt(0);   		
	    		p = new Usuario(pessoa[0], pessoa[1], pessoa[2], x, sexo, pessoa[5], pessoa[6], pessoa[7], y, pessoa[9], pessoa[10]);
	    		usuarios.add(p);
	    	}else {
	    		p = new Usuario(pessoa[0], pessoa[1], pessoa[2], x, sexo, pessoa[5], pessoa[6], pessoa[7], y, pessoa[9], pessoa[10]);
	    		usuarios.add(p);
	    	}
	    }
	}
	
	@GetMapping("/pagina-usuarios")
	@ApiOperation(value="Retorna uma pagina com 10 usuarios, ordem crescente, por id")
	public Page<Usuario> pagina10Usuarios(Integer numeroDaPagina){
		return usuarioPaginaRepository.findAll(PageRequest.of(numeroDaPagina, 10, Direction.ASC, "id"));
	}
	
	
	@GetMapping("/lista-usuarios")
	@ApiOperation(value="Retorna lista de usuarios")
	public List<Usuario> listaUsuarios(){
		return usuarioRepository.findAll(Sort.by(Direction.ASC, "id"));
	}
	
	@PostMapping("/salva-usuario")
	@ApiOperation(value="Salva um usuario")
	public Usuario salvaUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	//insere a lista em que esta o csv
	@PostMapping("/salva-usuarios")
	@ApiOperation(value="Salva os dados da csv")
	public void salvaUsuarios() {
		usuarioRepository.saveAll(usuarios);
	}
	
	@DeleteMapping("/deleta-usuario")
	@ApiOperation(value="Deleta um usuario")
	public void deletaUsuario(@RequestBody Usuario usuarios) {
		usuarioRepository.delete(usuarios);
	}
	
	@DeleteMapping("/deleta-usuarios")
	@ApiOperation(value="Deleta todos os usuarios")
	public void deletaTodosUsuarios() {
		usuarioRepository.deleteAll();
	}
		
}
