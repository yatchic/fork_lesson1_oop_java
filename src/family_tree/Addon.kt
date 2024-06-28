package family_tree

import java.util.regex.Pattern

class Addon:AddonInterface {

    override fun findTextB(text: String?, pattern: String?): Boolean
    {
        val errors=StringBuilder()
        var res=false
        try {
            val ptrn = Pattern.compile(pattern!!)
            val match = ptrn.matcher(text!!)
            res=match.find()

        }catch( e:IndexOutOfBoundsException){errors.append("IndexOutOfBoundsException    "+e)}
        catch( e:IllegalArgumentException){errors.append("IllegalArgumentException    "+e)}
        catch( e:IllegalStateException){errors.append("IllegalStateException   "+e)}
        catch( e:NullPointerException){errors.append("NullPointerException   "+e)}
        catch( e:ConcurrentModificationException){errors.append("ConcurrentModificationException    "+e)}
        return res

    }
    override fun findText(text: String?, pattern: String?): String? {
        val res=StringBuilder()
        val errors=StringBuilder()
        try{
            val builder = StringBuilder()
            val ptrn = Pattern.compile(pattern!!)
            val match = ptrn.matcher(text!!)
            if (match.find()) {
                res.append(match.group())
            }

        }catch( e:IndexOutOfBoundsException){errors.append("IndexOutOfBoundsException    "+e)}
        catch( e:IllegalArgumentException){errors.append("IllegalArgumentException    "+e)}
        catch( e:IllegalStateException){errors.append("IllegalStateException   "+e)}
        catch( e:NullPointerException){errors.append("NullPointerException   "+e)}
        catch( e:ConcurrentModificationException){errors.append("ConcurrentModificationException    "+e)}
        res.append(errors.toString())

        return res.toString()

    }


}