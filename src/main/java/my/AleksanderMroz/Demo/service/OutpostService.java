package my.AleksanderMroz.Demo.service;

import my.AleksanderMroz.Demo.to.OutpostTo;

public interface OutpostService {


    OutpostTo saveOutpost(OutpostTo outpost);
    void deleteOutpost(Long id);
}
