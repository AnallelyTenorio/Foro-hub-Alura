package com.alura.foro_hub.controller;

import com.alura.foro_hub.domain.topic.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private TopicService topicService;

    //Registrar un tópico
    @PostMapping
    public ResponseEntity<Topic> registerTopic(@RequestBody @Valid DatosRegistroTopic datosRegistroTopic){
        Topic newTopic = topicService.createTopic(datosRegistroTopic);
        return new ResponseEntity<>(newTopic, HttpStatus.CREATED);
    }

    //Listar tópicos
    @GetMapping
    public Page<DatosListadoTopic> listadoTopics(@PageableDefault(sort = "creationDate", direction = Sort.Direction.ASC)Pageable pageable){
        Page<Topic> topics = topicService.findAll(pageable);
        return topics.map(topic -> new DatosListadoTopic(
              topic.getTitle(),
              topic.getMessage(),
              topic.getCreationDate(),
              topic.getStatus(),
              topic.getAuthor().getName(),
              topic.getCourse().getName()
        ));
    }

    //Buscar tópicos por nombre del curso
    @GetMapping("/search")
    public Page<DatosListadoTopic> searchTopics(@RequestParam String courseName,  @PageableDefault(sort = "creationDate", direction = Sort.Direction.ASC) Pageable pageable) {
            Page<Topic> topics = topicService.findByCourseName(courseName, pageable);
            return topics.map(topic -> new DatosListadoTopic(
               topic.getTitle(),
               topic.getMessage(),
               topic.getCreationDate(),
               topic.getStatus(),
               topic.getAuthor().getName(),
               topic.getCourse().getName()
       ));
    }

    //Obtener información de tópico por id
    @GetMapping("/{id}")
    public ResponseEntity<DatosListadoTopic> getTopicsDetails(@PathVariable Long id){
        Topic topic = topicService.getTopicById(id);
        if (topic == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        DatosListadoTopic detalleTopic = new DatosListadoTopic(
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreationDate(),
                topic.getStatus(),
                topic.getAuthor().getName(),
                topic.getCourse().getName()
        );
        return new ResponseEntity<>(detalleTopic, HttpStatus.OK);
    }

    //Actualizar tópico
    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Long id, @RequestBody @Valid DatosRegistroTopic datosRegistroTopic){
        Topic existingTopic = topicService.getTopicById(id);
        if (existingTopic == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Topic updatedTopic = topicService.updateTopic(existingTopic, datosRegistroTopic);
        return new ResponseEntity<>(updatedTopic, HttpStatus.OK);

    }

    //Eliminar tópico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id){
        try {
            topicService.deleteTopic(id);
            return ResponseEntity.noContent().build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

}
