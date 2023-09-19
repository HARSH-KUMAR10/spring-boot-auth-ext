package com.harshkumar093.jpa.service.module;

import com.harshkumar093.jpa.model.module.CoreModule;
import com.harshkumar093.jpa.model.module.Module;
import com.harshkumar093.jpa.model.user.CoreUser;
import com.harshkumar093.jpa.payload.request.AddModulesRequest;
import com.harshkumar093.jpa.payload.response.ResponseMessage;
import com.harshkumar093.jpa.repo.CoreModuleRepository;
import com.harshkumar093.jpa.repo.CoreUserRepository;
import com.harshkumar093.jpa.repo.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CoreModuleService {
    @Autowired
    CoreModuleRepository coreModuleRepository;

    @Autowired
    CoreUserRepository coreUserRepository;

    @Autowired
    ModuleRepository moduleRepository;

    public ResponseMessage addModules(AddModulesRequest addModulesRequest){
        CoreUser coreUser = this.coreUserRepository.findByUserId(addModulesRequest.userId);
        ArrayList<Module> modules = new ArrayList<>(this.moduleRepository.findAllById(addModulesRequest.moduleIds));
        this.coreModuleRepository.save(new CoreModule(coreUser, modules));
        return new ResponseMessage("200","New modules were added for user"+addModulesRequest.userId);
    }
}
