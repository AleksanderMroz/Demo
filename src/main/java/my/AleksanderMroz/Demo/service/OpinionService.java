package my.AleksanderMroz.Demo.service;

import my.AleksanderMroz.Demo.to.OpinionTo;

public interface OpinionService {


    OpinionTo saveOpinion(OpinionTo opinion);
    void deleteOpinion(Long id);

}
