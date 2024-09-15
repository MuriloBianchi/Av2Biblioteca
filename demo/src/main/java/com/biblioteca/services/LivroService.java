package com.biblioteca.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.domains.Bibliotecario;
import com.biblioteca.domains.Livro;
import com.biblioteca.domains.dtos.LivroDTO;
import com.biblioteca.repositories.LivroRepository;
import com.biblioteca.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepo;

    @Autowired
    private BibliotecarioService bibliService;

    public List<LivroDTO> findAll(){
        return livroRepo.findAll().stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
    }

    public Livro findById(Long id) {
        Optional<Livro> obj = livroRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado no sistema! ID: " + id));
    }

    public Livro findByTitulo(String titulo){
        Optional<Livro> obj = livroRepo.findByTitulo(titulo);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado no sistema! Titulo: " + titulo));
    }

    public List<LivroDTO> findByAutor(String autor){
        return livroRepo.findByAutor(autor).stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
    }

    public List<LivroDTO> findByFaixaEtaria(Integer faixaEtaria){
        return livroRepo.findByFaixaEtaria(faixaEtaria).stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
    }

    public Livro create(LivroDTO objDto) {
        Bibliotecario bibli = bibliService.findById(objDto.getBibliotecario());

        objDto.setId(null);
        Livro newObj = new Livro(objDto);

        newObj.setBibliotecario(bibli);
        return livroRepo.save(newObj);
    }

    public Livro update(Long id, LivroDTO objDto) {
        objDto.setId(id);
        Livro oldObj = findById(id);

        Bibliotecario bibli = bibliService.findById(objDto.getBibliotecario());

        oldObj = new Livro(objDto);
        oldObj.setBibliotecario(bibli);
        return livroRepo.save(oldObj);
    }

        public void delete(Long id) {
        livroRepo.deleteById(id);
    }
}
