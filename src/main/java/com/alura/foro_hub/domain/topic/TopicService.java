package com.alura.foro_hub.domain.topic;

import com.alura.foro_hub.domain.author.Author;
import com.alura.foro_hub.domain.author.AuthorRepository;
import com.alura.foro_hub.domain.course.Course;
import com.alura.foro_hub.domain.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public Topic createTopic(DatosRegistroTopic datosRegistroTopic){

        Optional<Topic> existingTopic = topicRepository.findByTitleAndMessage(datosRegistroTopic.getTitle(), datosRegistroTopic.getMessage());
        if(existingTopic.isPresent()){
            throw new IllegalArgumentException("Ya existe un topico con el mismo titulo y mensaje");
        }
        Author author = authorRepository.findByNameAndEmail(datosRegistroTopic.getAuthor().getName(), datosRegistroTopic.getAuthor().getEmail())
                .orElseGet(()->authorRepository.save(datosRegistroTopic.getAuthor()));
        Course course = courseRepository.findByName(datosRegistroTopic.getCourse().getName())
                .orElseGet(()->courseRepository.save(datosRegistroTopic.getCourse()));

        Topic topic = new Topic();
        topic.setTitle(datosRegistroTopic.getTitle());
        topic.setMessage(datosRegistroTopic.getMessage());
        topic.setAuthor(author);
        topic.setCourse(course);
        topic.setStatus("OPEN");

        return topicRepository.save(topic);

    }

    public Page<Topic> findAll(Pageable pageable) {
        return topicRepository.findAll(pageable);
    }

    public Page<Topic> findByCourseName(String courseName, Pageable pageable) {
        return topicRepository.findByCourseName(courseName, pageable);
    }

    public Topic getTopicById(Long id){
        return topicRepository.findById(id).orElse(null);
    }

    //Actualizar tópico
    @Transactional
    public Topic updateTopic(Topic topic, DatosRegistroTopic datosRegistroTopic){
        //Valida si hay duplicados
        Optional<Topic> existingTopicByTitleAndMessage = topicRepository.findByTitleAndMessage(datosRegistroTopic.getTitle(), datosRegistroTopic.getMessage());
        if (existingTopicByTitleAndMessage.isPresent() && !existingTopicByTitleAndMessage.get().getId().equals(topic.getId())){
            throw new IllegalArgumentException("Ya existe un tópico con el mismo título y mensaje");
        }
        topic.setTitle(datosRegistroTopic.getTitle());
        topic.setMessage(datosRegistroTopic.getMessage());

        //Verificar autor
        Author author = datosRegistroTopic.getAuthor();
        if (author != null && author.getId() == null){
            Optional<Author> existingAuthorOptional = authorRepository.findByNameAndEmail(author.getName(), author.getEmail());
            if (existingAuthorOptional.isPresent()){
                author = existingAuthorOptional.get();
            }else {
                author = authorRepository.save(author);
            }
            topic.setAuthor(author);
        }
        //Verificar curso
        Course course = datosRegistroTopic.getCourse();
        if (course != null){
            Optional<Course> existingCourseOptional = courseRepository.findByName(course.getName());
            if (existingCourseOptional.isPresent()){
                course = existingCourseOptional.get();
            }else {
                course = courseRepository.save(course);
            }
            topic.setCourse(course);
        }
        return topicRepository.save(topic);
    }

    //Eliminar un tópico
    @Transactional
    public void deleteTopic(Long id){
        Optional<Topic>existingTopicOptional = topicRepository.findById(id);
        if(!existingTopicOptional.isPresent()){
            throw new IllegalArgumentException("No se encontro el tópico con el ID: "+id);
        }
        topicRepository.deleteById(id);
    }
}
