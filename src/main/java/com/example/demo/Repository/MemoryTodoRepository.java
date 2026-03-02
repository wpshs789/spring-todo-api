//package com.example.demo.Repository;
//
//import org.springframework.stereotype.Repository;
//import com.example.demo.Service.Todo;
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Optional;
//
//@Repository
//public class MemoryTodoRepository implements TodoRepository {
//    private final List<Todo> store = new ArrayList<>();
//
//    @Override
//    public List<Todo> findAll() {
//        return store;
//    }
//
//    @Override
//    public Optional<Todo> findById(Long id) {
//        return store.stream()
//                .filter(t -> t.getId().equals(id))
//                .findFirst();
//    }
//
//    @Override
//    public Todo save(Todo todo) {
//        for(int i = 0; i < store.size(); i++) {
//            if(store.get(i).getId().equals(todo.getId())) {
//                store.set(i, todo);
//                return todo;
//            }
//        }
//        store.add(todo);
//        return todo;
//    }
//
//    @Override
//    public boolean deleteById(Long id) {
//        return store.removeIf(t -> t.getId().equals(id));
//    }
//}
