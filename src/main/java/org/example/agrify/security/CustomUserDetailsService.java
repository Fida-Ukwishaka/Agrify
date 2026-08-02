package org.example.agrify.security;

import lombok.RequiredArgsConstructor;
import org.example.agrify.repository.WorkerRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final WorkerRepository workerRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        return workerRepository.findByEmail(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Worker not found"));
    }
}