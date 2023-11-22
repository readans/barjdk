package org.barjdk.implement;

import lombok.extern.slf4j.Slf4j;
import org.barjdk.entity.PermisoRolEntity;
import org.barjdk.entity.RolEntity;
import org.barjdk.repository.PermisoRolRepository;
import org.barjdk.repository.RolRepository;
import org.barjdk.services.PermisoRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PermisoRolImplement implements PermisoRolService {

    //Logger log = LoggerFactory.getLogger(PermisoRolImplement.class);

    @Autowired
    PermisoRolRepository permisoRolRepository;
    @Autowired
    RolRepository rolRepository;

    @Override
    public List<PermisoRolEntity> consultarPorRol(RolEntity rolEntity) {
        return this.permisoRolRepository.findByRol(rolEntity);
    }
}
