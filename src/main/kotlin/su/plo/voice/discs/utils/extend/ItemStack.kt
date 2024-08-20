package su.plo.voice.discs.utils.extend

import net.kyori.adventure.text.TextComponent
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType
import su.plo.voice.discs.DiscsPlugin

fun ItemStack.isCustomDisc(plugin: DiscsPlugin) = this
    .takeIf { this.type.isRecord }
    ?.itemMeta
    ?.hasDisplayName() ?: false
//    ?.itemMeta
//    ?.persistentDataContainer
//    ?.let { it.has(plugin.identifierKey) || it.has(plugin.oldIdentifierKey) }
//    ?: false

fun ItemStack.customDiscIdentifier(plugin: DiscsPlugin): String? =
    this.takeIf { isCustomDisc(plugin) }
        ?.itemMeta
        ?.displayName()
        ?.let { it as? TextComponent }
        ?.content()
//        ?.persistentDataContainer
//        ?.let {
//            it.get(plugin.identifierKey, PersistentDataType.STRING) ?:
//            it.get(plugin.oldIdentifierKey, PersistentDataType.STRING)
//        }
