package controllers;

import models.Curriculum;
import play.*;
import play.api.templates.Html;
import play.data.Form;
import play.mvc.*;

import views.html.*;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {
    //Curriculum
    public static List<Curriculum> curriculumList = new ArrayList<Curriculum>();
    public static Form<Curriculum> curriculumForm = Form.form(Curriculum.class);
    public static Curriculum curriculum;

    //View
    public static Result showView(Html content) {
        session("status-logged", "admin");
        return ok(showView.render(content));
    }



    public static Result home() {
        return showView(home.render());
    }
    //Curriculum
    public static Result listCurriculum() {
        curriculumList = Curriculum.list();
        return showView(listCurriculum.render(curriculumList));
    }

    public static Result formNewCurriculum() {
        curriculumForm = Form.form(Curriculum.class);
        return showView(formNewCurriculum.render(curriculumForm));
    }

    public static Result createCurriculum() {
        Form<Curriculum> newCurriculumForm = curriculumForm.bindFromRequest();
        if (newCurriculumForm.hasErrors()) {
            session("errMsg", "ท่านป้อนข้อมูลไม่สมบูรณ์/ไม่ถูกต้อง กรุณาตรวจสอบและแก้ไขให้ถูกต้อง ...");
            return showView(formNewCurriculum.render(newCurriculumForm));
        } else {
            curriculum = newCurriculumForm.get();
            Curriculum.create(curriculum);
            return redirect("/listCurriculum");
        }
    }

    public static Result formUpdateCurriculum(String odId) {
        curriculum = Curriculum.find.byId(odId);
        curriculumForm = Form.form(Curriculum.class).fill(curriculum);
        return showView(formUpdateCurriculum.render(curriculumForm));


    }

    public static Result updateCurriculum() {
        Form<Curriculum> newCurriculumForm = curriculumForm.bindFromRequest();
        if (newCurriculumForm.hasErrors()) {
            session("errMsg", "ท่านป้อนข้อมูลไม่สมบูรณ์/ไม่ถูกต้อง กรุณาตรวจสอบและแก้ไขให้ถูกต้อง ...");
            return showView(formUpdateCurriculum.render(newCurriculumForm));
        } else {
            curriculum = newCurriculumForm.get();
            Curriculum.update(curriculum);
            return redirect("/listCurriculum");
        }
    }

    public static Result deleteCurriculum(String odId) {
        curriculum = Curriculum.find.byId(odId);
        if (curriculum != null)
            Curriculum.delete(curriculum);
        return redirect("/listCurriculum");
    }


}
