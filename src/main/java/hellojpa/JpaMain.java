package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf  =Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            /*등록
            Member member = new Member();
            member.setId(1L);
            member.setName("helloA");

            em.persist(member);
            */

            /*조회
            Member findMember = em.find(Member.class , 1L);
            System.out.println("findManager  : " + findMember.getId());
            System.out.println("findManager  : " + findMember.getName());
            */

            /*수정
            Member findMember = em.find(Member.class , 1L);
            findMember.setName("helloJPA");
            */

            /*JPQL
            List<Member> result = em.createQuery("select m from Member as m" , Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();

            result.forEach(member->{
                System.out.println("member.name = " + member.getName());
            });

            for (Member member : result){
                System.out.println("member.name = " + member.getName());
            }
            */

            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
