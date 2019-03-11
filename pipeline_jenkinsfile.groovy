 def proyect_client = "${PROJECT_CLIENT}"
 def project_name = "${PROJECT_NAME}"

 // Variables locales (Propias de la clase)
 def url_git = "${URL_SCM}"
 def branch_scm = "${BRANCH_SCM}"
 def credentials_scm = "${CREDENTIALS}"

 folder(proyect_client) {
     description('Cliente ' + proyect_client)
 }

 folder(proyect_client + '/' + project_name) {
 }

pipelineJob(proyect_client + '/' + project_name + '/'  + project_name + '_Pipeline') {
    definition {
        cpsScm {
        scm{  
            git{
                remote{
                    url(url_git)
                    branch(branch_scm)
                    credentials(credentials_scm)
                  }
                }
            }
         
         triggers {
        scm('*/15 * * * *')
        }

            lightweight(true)
        }
    }
}
